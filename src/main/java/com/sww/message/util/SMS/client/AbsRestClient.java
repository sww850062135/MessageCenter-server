
package com.sww.message.util.SMS.client;



public abstract class AbsRestClient {
	private  static final String  server = "open.ucpaas.com";
	
	/**
	 * 指定模版单发
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param templateid	模板ID
	 * @param temp			模板中的替换参数
	 * @param mobile		接收的单个手机号
	 * @param uid			用户透传ID，随状态报告返回
	 * @return
	 */
	public abstract String sendSms(String sid, String token, String appid, String templateid, String temp, String mobile, String uid);


	/**
	 * 指定模版单发
	 * @param sid			用户的账号唯一标识
	 * @param token			用户密钥
	 * @param appid			创建应用时系统分配的唯一标识
	 * @param templateid	模板ID
	 * @param temp			模板中的替换参数
	 * @param mobile		接收的手机号,多个手机号码以英文逗号分隔
	 * @param uid			用户透传ID，随状态报告返回
	 * @return
	 */

    public abstract String sendSmsBatch(String sid, String token, String appid, String templateid, String temp, String mobile, String uid);


	public StringBuffer getStringBuffer() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(server).append("/ol/sms");
		return sb;
	}
}

