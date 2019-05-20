package com.bjbank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		JSONObject postBody = new JSONObject();
		postBody.put("data", list);

		System.out.println("json:" + postBody.toJSONString());
		Request request = new Request.Builder().addHeader("Authorization", token)
				.url(Const.IP + "api/bank/updateTransaction")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString())).build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);


			  String result = response.body().string();
			
			 JSONObject rJsonObj = JSONObject.parseObject(result);
			 String msg = (String)rJsonObj.get(Const.msg);
			 System.out.println("更新平台银行账户 结果: " + msg);
			 if(msg==null || msg.equalsIgnoreCase(Const.success_msg)) {
				 System.out.println("更新平台银行账户 结果: " + rJsonObj.getString("data"));
			 }
		}catch (Exception e) {
			System.out.println( "updateTransaction 异常信息：" + e.getMessage());
		}
	}

	public static void updateCompanyAccount(List<Object> list, String token) throws IOException {

		System.out.println("++++++++++updateCompanyAccount+++++++++++++++");
		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		JSONObject postBody = new JSONObject();
		postBody.put("data", list);

		Request request = new Request.Builder().addHeader("Authorization", token)
				.url(Const.IP + "api/bank/updateCompanyAccount")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString())).build();

		try (Response response = client.newCall(request).execute()) {

			 String result = response.body().string();
			
			 JSONObject rJsonObj = JSONObject.parseObject(result);
			 String msg = (String)rJsonObj.get(Const.msg);
			 System.out.println("更新平台银行账户 结果: " + msg);
			 if(msg==null || msg.equalsIgnoreCase(Const.success_msg)) {
				 System.out.println("更新平台银行账户 结果: " + rJsonObj.getString("data"));
			 }
			 
		} catch (Exception e) {
			System.out.println( "updateCompanyAccount 异常信息：" + e.getMessage());
		}
	}

	/**
	 * 获取平台列表
	 * 
	 * @param token
	 * @throws IOException
	 */
	public static List<Company> getCompanyList(String token) throws IOException {
		System.out.println("++++++++++getCompanyList+++++++++++++++");

		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		Request request = new Request.Builder().addHeader("Authorization", token)
				.url(Const.IP + "api/bank/getCompanyList").post(RequestBody.create(MEDIA_TYPE_MARKDOWN, "")).build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			String ss = response.body().string();

			JSONObject json = JSONObject.parseObject(ss);
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
	}

	public static String getToken() {
		return "1111";
	}

	/**
	 * 获取getToken
	 * 
	 * @return
	 */
	public static String getToken1() {

		OkHttpClient client = new OkHttpClient();

		MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

		JSONObject postBody = new JSONObject();
		postBody.put("username", Const.username);
		postBody.put("password", Const.password);

		System.out.println("json:" + postBody.toJSONString());
		Request request = new Request.Builder().url(Const.IP + "api/bank/getToken")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString())).build();

		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {

			System.out.println("getToken 失败,原因 :" + e.getMessage());
		}

		String s = null;
		try {
			s = response.body().string();
		} catch (IOException e) {
			System.out.println("getToken body失败,原因 :" + e.getMessage());
		}

		JSONObject json = JSONObject.parseObject(s);

		Object token = json.get("token");

		return token.toString();
	}

}
