package com.sww.message.service.impl;

import com.sww.message.entity.Sms;
import com.sww.message.mapper.SmsMapper;
import com.sww.message.service.SmsService;
import com.sww.message.util.SMS.client.AbsRestClient;
import com.sww.message.util.SMS.client.JsonReqClient;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {

    private static final String TOKEN = "bfa3998ed6c4b79114fc198d7128e4f8";         //鉴权密钥
    private static final String APP_ID = "4c3210d1323b42e4a92fc4b1e9cff331";        //应用ID
    private static final String ACCOUNT_SID = "6a134d2969765f84d9e83741c856d53b";   //用户sid

    private static AbsRestClient InstantiationRestAPI() {
        return new JsonReqClient();
    }

    @Autowired
    private SmsMapper smsMapper;

    /**
     * 指定模版单发
     * @param sms
     * @return
     */
    @Override
    public int SendSms(Sms sms) {
        try {
            String result = InstantiationRestAPI().sendSms(ACCOUNT_SID, TOKEN, APP_ID, sms.getTemplateid(),
                    sms.getTemp(), sms.getMobile(), sms.getUid());
            System.out.println("Response content is: " + result);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    /**
     * 指定模版群发
     * @param sms
     * @return
     */
    @Override
    public  int SendSmsBatch(Sms sms) {
        try {
            String result=InstantiationRestAPI().sendSmsBatch(ACCOUNT_SID, TOKEN, APP_ID, sms.getTemplateid(),
                    sms.getTemp(), sms.getMobile(), sms.getUid());
            System.out.println("Response content is: " + result);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 增加一条sms记录
     * @param sms
     * @return
     */
    @Override
    public int add(Sms sms) {
        return smsMapper.add(sms);
    }

    /**
     * 查询sms列表
     * @param pageNum       当前页
     * @param pageSize      每页显示的条数
     * @return
     */
    @Override
    public List<Sms> getSmsList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);        //使用分页插件实现分页查询
        return smsMapper.getSmsList();
    }

    /**
     * 根据手机号mobile查询sms列表
     * @param mobile
     * @return
     */
    @Override
    public List<Sms> getSmsListByMobile(String mobile) {
        return smsMapper.getSmsListByMobile(mobile);
    }


}
