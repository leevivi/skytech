package com.skytech.api.service.impl;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.mapper.TMemberMessageMapper;
import com.skytech.api.mapper.TMessageMapper;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseTMessageExample;
import com.skytech.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/4/7.
 */
@Service("messageService")
public class MessageServiceImpl extends GenericOneServiceImpl<TMessage,TMessageExample,Integer> implements MessageService {

    @Autowired
    private TMessageMapper tMessageMapper;
    @Autowired
    private TMemberMessageMapper tMemberMessageMapper;
    @Override
    protected GenericOneMapper<TMessage, TMessageExample, Integer> getGenericOneMapper() {
        return this.tMessageMapper;
    }

    @Override
    public Pagination<TMessage> findForPage(int page, int limit) {
        TMessageExample tMessageExample = new TMessageExample();
        BaseTMessageExample.Criteria criteria = tMessageExample.createCriteria();

        Pagination<TMessage> pagination = this.queryByPage(tMessageExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public Map<String, Object> myMessage(int memberId, int messageType) {
        List<MyMessage> list = new ArrayList<>();
        HashMap<String,Object> data = new HashMap<>();
        TMemberMessageExample tMemberMessageExample = new TMemberMessageExample();
        tMemberMessageExample.createCriteria().andMemberidEqualTo(memberId).andTypeEqualTo(messageType);
        List<TMemberMessage> tMemberMessages =tMemberMessageMapper.selectByExample(tMemberMessageExample);
        if(!tMemberMessages.isEmpty()){
            for (TMemberMessage tmm :tMemberMessages) {
                TMessageExample tMessageExample = new TMessageExample();
                tMessageExample.createCriteria().andIdEqualTo(tmm.getMessageid());
                List<TMessage> tMessages = tMessageMapper.selectByExample(tMessageExample);
                for (TMessage tMessage :tMessages) {
                    MyMessage myMessage = new MyMessage();
                    myMessage.setMessageTitle(tMessage.getMsgtheme());
                    myMessage.setMessageBody(tMessage.getMsgbody());
                    //2019-04-08 12:00:00-Apir 8,2019 12:00:00
                    myMessage.setMessageTime(tMessage.getMsgtime());
                    list.add(myMessage);
                }
            }
            data.put("MyMessage",list);
        }
        return data;
    }
}