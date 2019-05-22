package com.bjbank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 与财政局交互类
 * 
 * @author sunning
 *
 */
public class BJBankUitl {

	private static final Logger logger =LoggerFactory.getLogger(BJBankUitl.class);
	/**
	 * 获取yyyy-MM-dd 时间格式字符串
	 * 
	 * @return
	 */
	public static String getTimeStr() {
		java.text.SimpleDateFormat s = new java.text.SimpleDateFormat("yyyy-MM-dd");

		String dateStr = s.format(new Date());
		return dateStr;
	}

	public static void updateTransaction(List<Object> list, String token) throws IOException {
		System.out.println("++++++++++updateTransaction+++++++++++++++");
		logger.info("++++++++++updateTransaction+++++++++++++++");
		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		JSONObject postBody = new JSONObject();
		postBody.put("data", list);

		System.out.println("json:" + postBody.toJSONString());
		Request request = new Request.Builder().addHeader("Authorization", token)
				.url(Const.IP + "api/bank/updateTransaction")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString())).build();

		try {
			Response response = client.newCall(request).execute();

			  String result = response.body().string();
				logger.info("updateTransaction result:{}",result);
			 JSONObject rJsonObj = JSONObject.parseObject(result);
			 String msg = (String)rJsonObj.get(Const.msg);
			 System.out.println("更新平台银行账户 结果: " + msg);
			 if(msg==null || msg.equalsIgnoreCase(Const.success_msg)) {
				 System.out.println("更新平台银行账户 结果: " + rJsonObj.getString("data"));
			 }
		}catch (Exception e) {
			System.out.println( "updateTransaction 异常信息：" + e.getMessage());
			logger.info("updateTransaction http exception:{}",e.getMessage());
		}
	}

	public static void updateCompanyAccount(List<Object> list, String token) throws IOException {

		System.out.println("++++++++++updateCompanyAccount+++++++++++++++");
		logger.info("++++++++++updateCompanyAccount+++++++++++++++");
		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		JSONObject postBody = new JSONObject();
		postBody.put("data", list);

		Request request = new Request.Builder().addHeader("Authorization", token)
				.url(Const.IP + "api/bank/updateCompanyAccount")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString())).build();

		try {
			 Response response = client.newCall(request).execute();
			 String result = response.body().string();
			 logger.info("updateCompanyAccount result:{}",result);
			 JSONObject rJsonObj = JSONObject.parseObject(result);
			 String msg = (String)rJsonObj.get(Const.msg);
			 System.out.println("更新平台银行账户 结果: " + msg);
			 if(msg==null || msg.equalsIgnoreCase(Const.success_msg)) {
				 System.out.println("更新平台银行账户 结果: " + rJsonObj.getString("data"));
			 }
			 
		} catch (Exception e) {
			System.out.println( "updateCompanyAccount 异常信息：" + e.getMessage());
			 logger.info("updateCompanyAccount exception:{}",e.getMessage());
		}
	}

	/**
	 * 获取平台列表
	 * 
	 * @param token
	 * @throws IOException
	 */
	public static List<Company> getCompanyList(String token)  {
		System.out.println("++++++++++getCompanyList+++++++++++++++");
        logger.info("++++++++++getCompanyList+++++++++++++++");
		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		Request request = new Request.Builder().addHeader("Authorization", token)
				.url(Const.IP + "api/bank/getCompanyList").post(RequestBody.create(MEDIA_TYPE_MARKDOWN, "")).build();

		try {
	
			Response response = client.newCall(request).execute();
			String resultJson = response.body().string();
	        logger.info("getCompanyList response {}",resultJson);
			JSONObject json = JSONObject.parseObject(resultJson);
			JSONArray jsonArr = json.getJSONArray("data");

			List<Company> companys = new ArrayList<>();
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Company company = new Company();
				company.setCompanyCode(jsonObj.getString("companyCode"));
				company.setCompanyName(jsonObj.getString("companyName"));
				companys.add(company);
			}
			return companys;
		}
		catch (Exception e) {
			System.out.println("获取公司平台列表失败,原因是:"+e.getMessage());
			logger.info("getCompanyList  exception :{}",e.getMessage());
			return null;
		}
	}

	/**
	 * 获取getToken
	 * 
	 * @return
	 */
	public static String getToken() {

		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		JSONObject postBody = new JSONObject();
		postBody.put("username", Const.username);
		postBody.put("password", Const.password);

		logger.info("getToken postBoby:{}",postBody.toJSONString());
		Request request = new Request.Builder().url(Const.IP + "api/bank/getToken")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString())).build();

		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {

			System.out.println("getToken 失败,原因 :" + e.getMessage());
			logger.info("getToken  http exception {}",e.getMessage());
		}

		String s = null;
		try {
			s = response.body().string();
			logger.info("getToken response body:{}",s);
		} catch (IOException e) {
			System.out.println("getToken body失败,原因 :" + e.getMessage());
			logger.info("getToken exception body:{}",e.getMessage());
		}

		JSONObject json = JSONObject.parseObject(s);

		Object token = json.get("token");
		logger.info("getToken token :{}",token);
		return token.toString();
	}

}
