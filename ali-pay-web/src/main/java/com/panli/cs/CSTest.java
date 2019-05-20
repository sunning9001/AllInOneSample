package com.panli.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CSTest {

	public static void main(String[] args) throws IOException {
		
		//getToken();
		  
		List<CompanyAccount> list =new ArrayList<>();
		
		CompanyAccount ca =new CompanyAccount();
		ca.setCompanyCode("91320282MA1TF0M15B");
		ca.setCompanyName("宜兴市艾尼环保科技有限公司");
		ca.setAccountName("ddddd");
		ca.setAccountType("1");

		ca.setAccountStatus("1");
		ca.setAccountOpenTime("2019-12-01 11:11:01");
		ca.setBank("北京银行");
		ca.setAccount("111111111111");
		ca.setAccountBalance("1.00");
		ca.setAvailableBalance("1.00");
		
	/*	
		CompanyAccount ca1 =new CompanyAccount();
		ca1.setCompanyCode("平台公司统一信用代码");
		ca1.setCompanyName("平台公司名称");
		ca1.setAccountName("账户名称");
		ca1.setAccountType("账户类型 1基本、2一般、3临时、4专用、5 其他");
		
		ca1.setAccountStatus("账户状态 1正常、2冻结、3已注销、4 止付");
		ca1.setAccountOpenTime(" timestamp 开户时间");
		ca1.setBank("开户行");
		ca1.setAccount("银行账号");
		ca1.setAccountBalance("账户余额（万元）");
		ca1.setAvailableBalance("可用余额（万元）");*/

		list.add(ca);
		/*list.add(ca1);*/
		
		String token ="";
		//updateCompanyAccount(list,token);
		
		getCompanyList(getToken());
		
		updateCompanyAccount( list,getToken()) ;
	}
	
	public static void updateTransaction(List<CompanyTransaction> list,String token) throws IOException {
		
		
		System.out.println("++++++++++updateTransaction+++++++++++++++");
		OkHttpClient client = new OkHttpClient();
		
		MediaType MEDIA_TYPE_MARKDOWN
		= MediaType.parse("application/json; charset=utf-8");
		
		JSONObject  postBody =new JSONObject();
		postBody.put("data", list);
		
		
		System.out.println("json:"+ postBody.toJSONString());
		Request request = new Request.Builder()
				.addHeader("Authorization", token)
				.url(Const.DEV_IP+"api/bank/updateTransaction")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString()))
				.build();
		
		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
			
			System.out.println(response.body().string());
		}
	}
	public static void updateCompanyAccount(List<CompanyAccount> list,String token) throws IOException {
		

		System.out.println("++++++++++updateCompanyAccount+++++++++++++++");
		OkHttpClient client = new OkHttpClient();
		
		  MediaType MEDIA_TYPE_MARKDOWN
		  = MediaType.parse("application/json; charset=utf-8");

		 JSONObject  postBody =new JSONObject();
		 postBody.put("data", list);
	
		 
		 System.out.println("json:"+ postBody.toJSONString());


		

	    Request request = new Request.Builder()
				.addHeader("Authorization", token)
			    .url(Const.DEV_IP+"api/bank/updateCompanyAccount")
		    .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString()))
		    .build();
	    
	    
	    
		try (Response response = client.newCall(request).execute()) {
		  
		
		  System.out.println(response.body().string());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void getCompanyList(String token) throws IOException {
		System.out.println("++++++++++getCompanyList+++++++++++++++");
	
		    OkHttpClient client = new OkHttpClient();
		
		    MediaType MEDIA_TYPE_MARKDOWN
			  = MediaType.parse("application/json; charset=utf-8");

		    Request request = new Request.Builder()
					.addHeader("Authorization", token)
			    .url(Const.DEV_IP+"api/bank/getCompanyList")
			    .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, ""))
			    .build();
		    
		    
		try (Response response = client.newCall(request).execute()) {
			  if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
		
			 String ss = response.body().string();
			 
			JSONObject json = JSONObject.parseObject(ss);
			 JSONArray jsonArr = json.getJSONArray("data");
			 
			 System.out.println(" 数量"+ jsonArr.size());
			 
			 Object[] array = jsonArr.toArray();
			 
			 for (Object obj : array) {
				
				 System.out.println(obj);
			}
			
			
		}
			  
		  
		  
	}
	public static String getToken() throws IOException {
		
		System.out.println("++++++++++getToken+++++++++++++++");
		OkHttpClient client = new OkHttpClient();
		
		  MediaType MEDIA_TYPE_MARKDOWN
		  = MediaType.parse("application/json; charset=utf-8");

		 JSONObject  postBody =new JSONObject();
		 postBody.put("username", "bjwxyh_admin");
		 postBody.put("password", "bjwxyh292804");
		 
		 System.out.println("json:"+ postBody.toJSONString());
		Request request = new Request.Builder()
		    .url(Const.DEV_IP+"api/bank/getToken")
		    .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody.toJSONString()))
		    .build();
		
		try (Response response = client.newCall(request).execute()) {
		  if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
		
		 String s=  response.body().string();
		  
		   JSONObject json = JSONObject.parseObject(s);
		  
		   Object token = json.get("token");
		   System.out.println("token " + token);
		   return token.toString();
		  
		}
	}
}
