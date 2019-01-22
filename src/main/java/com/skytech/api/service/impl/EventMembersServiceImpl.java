package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.impl.GenericServiceImpl;
import com.owthree.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.EventMapper;
import com.skytech.api.mapper.EventMembersMapper;
import com.skytech.api.mapper.RunningRecordMapper;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseEventMembersExample;
import com.skytech.api.service.EventMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("eventMembersService")
public class EventMembersServiceImpl extends GenericServiceImpl<EventMembers, EventMembersExample, String> implements EventMembersService {

    @Autowired
    private EventMembersMapper eventMembersMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RunningRecordMapper runningRecordMapper;

    @Override
    protected EventMembersMapper getGenericMapper() {
        return this.eventMembersMapper;
    }

    @Override
    public Pagination<EventMembers> findForPage(int page, int limit) {
        EventMembersExample eventMembersExample = new EventMembersExample();
        BaseEventMembersExample.Criteria criteria = eventMembersExample.createCriteria();

        Pagination<EventMembers> pagination = this.queryByPage(eventMembersExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(EventMembers eventMembers) {

        EventMembersExample eventMembersExample = new EventMembersExample();

        List<EventMembers> eventMemberss = eventMembersMapper.selectByExample(eventMembersExample);

        eventMembers.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
//        eventMembers.setCreatedDatetime(new Date());
        int i = eventMembersMapper.insertSelective(eventMembers);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String eventMembersSid, EventMembers eventMembers) {
        eventMembers.setSid(eventMembersSid);
        int i = eventMembersMapper.updateByPrimaryKeySelective(eventMembers);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... eventMembersSids) {

        try {
            for (int i = 0; i < eventMembersSids.length; i++) {
                EventMembers eventMembers = new EventMembers();

                eventMembers.setSid(eventMembersSids[i]);

                eventMembersMapper.updateByPrimaryKeySelective(eventMembers);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public List<Map<String, Object>> findForEvent(String eventSid) {
        EventMembersExample eventMembersExample = new EventMembersExample();
        eventMembersExample.createCriteria().andEventSidEqualTo(eventSid);

        List<EventMembers> eventMembers = eventMembersMapper.selectByExample(eventMembersExample);
        List<Map<String, Object>> members = new ArrayList<>();
        for (EventMembers eventMember : eventMembers) {
            Map<String, Object> m = new HashMap<>();
            String accountSid = eventMember.getAccountSid();
            Account account = accountMapper.selectByPrimaryKey(accountSid);
            m.put("accountSid", accountSid);
            m.put("accountName", eventMember.getAccountName());
            m.put("accountAvatar", account.getAvarta());


            RunningRecordExample runningRecordExample = new RunningRecordExample();
            runningRecordExample.createCriteria().andAccountSidEqualTo(accountSid);

            int distances = 0;

            List<RunningRecord> runningRecords = runningRecordMapper.selectByExample(runningRecordExample);
            for (RunningRecord record : runningRecords) {
                distances += record.getDistance();
            }
            m.put("distances", distances);

            members.add(m);
        }

        Collections.sort(members, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return new BigDecimal(o2.get("distances").toString()).compareTo(new BigDecimal(o1.get("distances").toString()));
            }
        });

        return members;
    }

    @Override
    public JsonMap save(String accountSid, String eventSid, String accountName, String staffId) {

        EventMembersExample eventMembersExample = new EventMembersExample();
        eventMembersExample.createCriteria().andEventSidEqualTo(eventSid).andAccountSidEqualTo(accountSid);
        int count = eventMembersMapper.countByExample(eventMembersExample);

        if (count > 0) {
            return JsonMap.of(false, "You had joined this event!");
        }

        Event event = eventMapper.selectByPrimaryKey(eventSid);

        EventMembers one = new EventMembers();
        one.setSid(UUIDUtil.getUUID());
        one.setAccountSid(accountSid);
        one.setAccountName(accountName);
        one.setEventSid(eventSid);
        one.setEventName(event.getEventName());
        one.setStaffId(staffId);
        one.setJoinedDatetime(new Date());
        int i = eventMembersMapper.insertSelective(one);

        if (i > 0) {
            return JsonMap.of(true, "SUCCESS");
        } else {
            return JsonMap.of(false, "FAILED");
        }

    }
}