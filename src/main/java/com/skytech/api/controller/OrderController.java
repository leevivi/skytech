package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.TMemberMapper;
import com.skytech.api.model.*;
import com.skytech.api.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/4/7.
 */
@EnableTransactionManagement
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TMemberMapper tMemberMapper;

    @ApiOperation(value = "我的订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", value = "orderStatus", required = true, dataType = "int")
    })
    @PostMapping(value = "/order/myOrder")
    public JsonMap myOrder(HttpSession session, int orderStatus) {
        Map<String, Object> data = new HashMap<>();
        List<MyOrder> list = new ArrayList<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        list = orderService.myOrder(accountSid, orderStatus);

        return JsonMap.of(true, "",list);

    }

    @ApiOperation(value = "退单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", value = "orderStatus", required = true, dataType = "int")
    })
    @Transactional
    @PostMapping(value = "/order/cancelConfirm")
    public JsonMap cancelConfirm(HttpSession session, String orderNum) {
        List<SelectCourseTime> list = new ArrayList<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        list = orderService.cancelConfirm(accountSid, orderNum);
        return JsonMap.of(true, "",list);

    }

    @ApiOperation(value = "退单确认")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", value = "orderStatus", required = true, dataType = "int")
    })
    @Transactional
    @PostMapping(value = "/order/cancelOrder")
    public JsonMap cancelOrder(HttpSession session, String orderNum,int[] tCourseTimeIds) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        try {
            return orderService.cancelOrder(accountSid, orderNum,tCourseTimeIds);
        } catch (Exception e) {
            return JsonMap.of(false,"");
        }


    }

    public Map<String,Object> checkMembers(Map<String, Object> data, String accountSid) {
        List<Object> memberInfoList = new ArrayList<>();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail()).andIsoverdueEqualTo(0);
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.isEmpty()||tMembers.get(0).getCompanyid()==null||tMembers.get(0).getStoresid()==null){
            List<TOrder> list = new ArrayList<>();
            data.put("data", list);
            return data;
        }
        for (TMember tMember :tMembers) {
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemberId(tMember.getId());
            memberInfo.setCompanyId(tMember.getCompanyid());
            memberInfo.setStoresId(tMember.getStoresid());
            memberInfoList.add(memberInfo);

        }
        data.put("memberInfoList",memberInfoList);
        return data;
    }
}
