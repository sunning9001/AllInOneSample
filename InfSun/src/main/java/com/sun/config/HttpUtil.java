package com.sun.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillSyncMessageResponse;
import com.sun.msg.request.BillSyncRequest;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * HTTP请求工具类
 * 
 * @author sunning
 *
 */
public class HttpUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	private static final OkHttpClient client = new OkHttpClient();
	private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

	/**
	 * 执行http post请求
	 * 
	 * @param postBody
	 * @param url
	 * @return
	 */
	public String httpExecute(String postBody, String url) {

		Request request = new Request.Builder().url(url).post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
				.build();
		try {
			Response response = client.newCall(request).execute();
			return response.body().toString();
		} catch (Exception e) {
			logger.debug(" 网络调用异常httpExecute : {}", e);
		}
		return null;
	}

	/**
	 * 转换成指定对象
	 * 
	 * @param postBody
	 * @param url
	 * @param clazz
	 * @return
	 */
	public Object httpExecute(String postBody, String url, Class clazz) {
		String rString = httpExecute(postBody, url);
		if (rString != null) {
			Object obj = JSONObject.parseObject(rString, clazz);
			return obj;
		}
		return null;

	}
	
	public static void main(String[] args) {
		
		//定时任务
		
		
		//select   setter   转换成需要的数据格式
		HttpUtil util =new HttpUtil();
		//消息对象
		BillSyncMessageRequest  msg =new BillSyncMessageRequest();
		msg.setZone_code("zonecode");
		msg.setMethod("wp.bill.sync");
		msg.setTimestamp("20180629010111");
		msg.setVersion("1.0");
		
		BillSyncRequest r= new BillSyncRequest();
		r.setChg_code("chg_code");
		msg.setBiz_content(r);
		

		String postBody = JSONObject.toJSONString(msg);
		 
		 
		String rString = util.httpExecute(postBody, "http://localhost:8181");
		
		BillSyncMessageResponse response =	JSONObject.parseObject(rString, BillSyncMessageResponse.class);
		
		//update
	}
	
	

}


