package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.TEventMembers;

import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/3/31.
 */
public interface TEventMembersService extends GenericOneService<TEventMembers,Integer>{
    Pagination<TEventMembers> findForPage(int page, int limit);

    List<Map<String, Object>> findForEvent(int eventSid);

    Map<String, Object> findForEventDetail(String accountSid, int tEventId);

    JsonMap save(TEventMembers tEventMembers);

    JsonMap save(String accountSid, int tEventId, String accountName);

    JsonMap update(int eventMembersSid, TEventMembers tEventMembers);

    JsonMap delete(int... eventMembersSids);
}
