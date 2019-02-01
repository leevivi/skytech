package com.skytech.api;

import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountDeviceMapper;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.DeviceMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.Device;
import com.skytech.api.service.SleepService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkytechApiApplicationTests {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private AccountDeviceMapper accountDeviceMapper;

    @Autowired
    private SleepService sleepService;

    @Test
    public void contextLoads() {
//        sleepService.getCurrentSleep("")
    }


}
