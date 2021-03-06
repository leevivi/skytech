package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericService;
import com.skytech.api.model.Event;

public interface EventService extends GenericService<Event, String> {

    Pagination<Event> findForPage(String accountSid, int page, int limit);

    JsonMap save(Event event);

    JsonMap update(String eventSid, Event event);

    JsonMap delete(String... eventSids);
}


