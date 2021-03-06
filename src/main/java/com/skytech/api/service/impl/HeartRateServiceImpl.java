package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.HeartRateMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.HeartRate;
import com.skytech.api.model.HeartRateExample;
import com.skytech.api.model.base.BaseHeartRateExample;
import com.skytech.api.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("heartRateService")
public class HeartRateServiceImpl extends GenericServiceImpl<HeartRate, HeartRateExample, String> implements HeartRateService {

    @Autowired
    private HeartRateMapper heartRateMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected HeartRateMapper getGenericMapper() {
        return this.heartRateMapper;
    }

    @Override
    public Pagination<HeartRate> findForPage(int page, int limit) {
        HeartRateExample heartRateExample = new HeartRateExample();
        BaseHeartRateExample.Criteria criteria = heartRateExample.createCriteria();

        Pagination<HeartRate> pagination = this.queryByPage(heartRateExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(HeartRate heartRate) {
        Account account = accountMapper.selectByPrimaryKey(heartRate.getAccountSid());
        heartRate.setAccountName(account.getFirstName() + account.getLastName());

        HeartRateExample heartRateExample = new HeartRateExample();
        int i = 0;
        if (null != heartRate.getRecordDate()) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(heartRate.getRecordDate());

            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            Date date1 = calendar.getTime();
            calendar.add(Calendar.DATE, 1);
            calendar.add(Calendar.SECOND, -1);
            Date date2 = calendar.getTime();
            heartRateExample.createCriteria().andAccountSidEqualTo(heartRate.getAccountSid()).andDeviceSidEqualTo(heartRate.getDeviceSid()).andRecordDateBetween(date1, date2);

            List<HeartRate> heartRates = heartRateMapper.selectByExample(heartRateExample);
            if (heartRates.isEmpty()) {
                //第一次传，新增
                heartRate.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
                heartRate.setCreatedDatetime(new Date());
                i = heartRateMapper.insertSelective(heartRate);
            } else {
                //没有传isManual字段或者isManual=0
                // 非手动测试数据，和数据库数据比较大小，保存心率低的数据
                if(heartRate.getIsManual() == null || heartRate.getIsManual() == 0){
                    HeartRate one = heartRates.get(0);
                    if(Integer.parseInt(one.getData())>Integer.parseInt(heartRate.getData())){
                        one.setCreatedDatetime(new Date());
                        one.setRecordDate(heartRate.getRecordDate());
                        one.setData(heartRate.getData());
                        i = heartRateMapper.updateByPrimaryKeySelective(one);
                    }
                    else {
                        return JsonMap.of(true, "心率大于当前，不保存");
                    }
                }
                //手动测试的心率，直接覆盖更新
                else if(heartRate.getIsManual()==1){
                    HeartRate one = heartRates.get(0);
                    one.setCreatedDatetime(new Date());
                    one.setRecordDate(heartRate.getRecordDate());
                    one.setData(heartRate.getData());
                    i = heartRateMapper.updateByPrimaryKeySelective(one);
                }
            }
        } else {
            heartRate.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
            heartRate.setCreatedDatetime(new Date());
            i = heartRateMapper.insertSelective(heartRate);
        }

        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String heartRateSid, HeartRate heartRate) {
        heartRate.setSid(heartRateSid);
        int i = heartRateMapper.updateByPrimaryKeySelective(heartRate);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... heartRateSids) {

        try {
            for (int i = 0; i < heartRateSids.length; i++) {
                HeartRate heartRate = new HeartRate();

                heartRate.setSid(heartRateSids[i]);

                heartRateMapper.updateByPrimaryKeySelective(heartRate);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public List<HeartRate> report(String accountSid, String deviceSid, Date startDate, Date endDate) {
        HeartRateExample heartRateExample = new HeartRateExample();
        heartRateExample.createCriteria().andAccountSidEqualTo(accountSid).andDeviceSidEqualTo(deviceSid).andRecordDateBetween(startDate, endDate);
        heartRateExample.setOrderByClause(" start_datetime asc");
        List<HeartRate> heartRates = heartRateMapper.selectByExample(heartRateExample);
        return heartRates;
    }

    @Override
    public String getNewest(String accountSid) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();

        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();
        HeartRateExample heartRateExample = new HeartRateExample();
        heartRateExample.createCriteria().andAccountSidEqualTo(accountSid).andRecordDateBetween(startDate, endDate);
        heartRateExample.setOrderByClause(" record_date desc");

        List<HeartRate> heartRates = heartRateMapper.selectByExample(heartRateExample);
        if (heartRates.isEmpty()) {
            return "0,0";
        } else {
            String heart = heartRates.get(0).getData()+","+heartRates.get(0).getRecordDate();
            return heart;
//            return Integer.parseInt(heartRates.get(0).getData());
        }
    }

    @Override
    public String getRecent(String accountSid) {
        HeartRateExample heartRateExample = new HeartRateExample();
        heartRateExample.createCriteria().andAccountSidEqualTo(accountSid);
        heartRateExample.setOrderByClause(" created_datetime desc");
        List<HeartRate> heartRates = heartRateMapper.selectByExample(heartRateExample);
        if(!heartRates.isEmpty()){
            HeartRate heartRate = heartRates.get(0);
            String heart = heartRate.getData()+","+ DateUtil.formatStandardDatetime(heartRate.getCreatedDatetime());
            return heart;
        }
        return "0,0";
    }
}