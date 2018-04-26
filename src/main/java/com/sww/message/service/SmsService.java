package com.sww.message.service;

import com.sww.message.entity.Sms;
import java.util.List;

public interface SmsService {


    //指定模版单发
    int SendSms(Sms sms);

    //指定模版群发
    int SendSmsBatch(Sms sms);

    //增加一条记录
    int add(Sms sms);

    //查询sms记录列表
   List<Sms> getSmsList(int pageNum, int pageSize);

    //根据手机号mobile查询sms记录
    List<Sms> getSmsListByMobile(String mobile);
}
