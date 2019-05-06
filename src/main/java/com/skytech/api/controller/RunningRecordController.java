package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.mapper.AccountDeviceMapper;
import com.skytech.api.mapper.RunningRecordMapper;
import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.AccountDeviceExample;
import com.skytech.api.model.RunningRecord;
import com.skytech.api.service.RunningRecordService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author 剑神卓凌昭
 * @date 2018-11-06 14:36:15
 */
@RestController
public class RunningRecordController {
    private final Logger LOGGER = LoggerFactory.getLogger(RunningRecordController.class);
    @Autowired
    private RunningRecordService runningRecordService;
    @Autowired
    private RunningRecordMapper runningRecordMapper;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/runningRecord/listForPage")
    public Map<String, Object> listForPage(String deviceSid, int page, int limit) {
        Map<String, Object> data = new HashMap<>();
        if(deviceSid==null){
            data.put("code", "2000");
            data.put("message", "成功");
            data.put("data", null);
            return data;
        }

        Pagination<RunningRecord> pagination = runningRecordService.findForPage(deviceSid, page, limit);


        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        data.put("data", pagination.getDataList());

        return data;
    }

    @ApiOperation(value = "获取指定日期运动记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recordTime", value = "记录时间", required = true, dataType = "Date")
    })
    @GetMapping(value = "/runningRecord/listForTime")
    public Map<String, Object> listForTime(HttpSession session, Date recordTime) {
        Map<String, Object> data = new HashMap<>();
        if(recordTime==null){
            data.put("code", "2000");
            data.put("message", "成功");
            data.put("data", null);
            return data;
        }

        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        List<RunningRecord> runningRecords = runningRecordService.findForTime(accountSid,recordTime);
        data.put("code", "2000");
        data.put("message", "成功");
        data.put("count", runningRecords.size());
        data.put("data", runningRecords);
        return data;
    }

    @ApiOperation(value = "获取当月运动记录日期")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "记录月份", required = true, dataType = "String")
    })
    @GetMapping(value = "/runningRecord/getRecordDate")
    public Map<String, Object> getRecordDate(HttpSession session, String month) {
        Map<String, Object> data = new HashMap<>();
        if(month==null){
            data.put("code", "2000");
            data.put("message", "成功");
            data.put("data", null);
            return data;
        }

        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        String headAndEndDateForMonth = DateUtil.getHeadAndEndDateForMonth(month);
        String startDate = headAndEndDateForMonth.split("~")[0];
        String endDate = headAndEndDateForMonth.split("~")[1];
        List<String> runningRecords = runningRecordMapper.getRecordDate(accountSid,startDate,endDate);
        data.put("code", "2000");
        data.put("message", "成功");
        data.put("count", runningRecords.size());
        data.put("data", runningRecords);
        return data;
    }

    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @GetMapping(value = "/runningRecord/listBySid")
    public JsonMap listBySid(String sid) {
        RunningRecord runningRecord = runningRecordService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", runningRecord);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "runningRecord", value = "", required = true, dataType = "RunningRecord")
    })
    @PostMapping(value = "/runningRecord/save")
    public JsonMap save(HttpSession session, RunningRecord runningRecord) {
        LOGGER.info("RunningRecord",runningRecord);
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        runningRecord.setAccountSid(accountSid);
        return runningRecordService.save(runningRecord);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "runningRecord", value = "", required = true, dataType = "RunningRecord")
    })
    @PostMapping(value = "/runningRecord/update")
    public JsonMap update(String dataId, RunningRecord runningRecord) {

        return runningRecordService.update(dataId, runningRecord);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/runningRecord/delete")
    public JsonMap delete(String sid) {

        return runningRecordService.delete(sid);

    }


    @GetMapping(value = "/runningRecord/getNewest")
    public JsonMap getNewest(HttpSession session) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        return runningRecordService.findNewest(accountSid);


    }
}
