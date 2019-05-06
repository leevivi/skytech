package com.skytech.api.mapper;

import com.skytech.api.model.RunningRecord;
import com.skytech.api.model.RunningRecordExample;
import com.skytech.api.core.mapper.GenericMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface RunningRecordMapper extends GenericMapper<RunningRecord, RunningRecordExample, String> {
    List<RunningRecord> findForTime(@Param("accountSid") String accountSid,
                                    @Param("startTime") Date startTime,
                                    @Param("endTime") Date endTime);

    List<String> getRecordDate(@Param("accountSid") String accountSid,
                                    @Param("startDate") String startDate,
                                    @Param("endDate") String endDate);
}