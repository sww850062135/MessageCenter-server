
package com.sww.message.util.SMS.client;


import com.alibaba.fastjson.JSONObject;
import com.sww.message.util.SMS.HttpClientUtil;


public class JsonReqClient extends AbsRestClient {
	
	@Override
	public String sendSms(String sid, String token, String appid, String templateid, String temp, String mobile,
			String uid) {
		
		String result = "";
		
		try {
			String url = getStringBuffer().append("/sendsms").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", temp);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String sendSmsBatch(String sid, String token, String appid, String templateid, String temp, String mobile, String uid) {
		String result = "";

		try {
			String url = getStringBuffer().append("/sendsms_batch").toString();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", temp);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);

			String body = jsonObject.toJSONString();

			System.out.println("body = " + body);

			result = HttpClientUtil.postJson(url, body, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
