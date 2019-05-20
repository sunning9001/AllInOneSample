/**
@CreateTime: sunning2019年3月21日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

 package com.panli.paypal;

import java.io.IOException;
import java.nio.charset.Charset;

import com.alibaba.fastjson.JSONObject;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

/**
 * @author sunning
 * @date 2019/03/21
 */
public class PayPalTestMain {

    
    public static void main(String[] args) throws IOException {
        
        
       OkHttpClient client = new OkHttpClient.Builder().authenticator(new Authenticator() {
        
        @Override
        public Request authenticate(Route route, Response response) throws IOException {
            String credential = Credentials
                .basic("Ae1W4TjVCqlxmAlePCvHON3d1iCeKdd5tJUcbAZNvNaNJx5vU_eKHOvxT1sWMx-A-vmYJqj8m7layDFe", "ELpEq4kI7kpVnJ2L7-jlGPSqoA-95tU6LYFA8oVTVPW7wJ7Oa8HbpqKOI2rUY_BqN_Q6VlVVLiXMEkhD",Charset.forName("UTF-8"));
            return response.request().newBuilder()
                    .header("Authorization", credential)
                    .build();
        }
    }).build();
       
      


        RequestBody formBody = new FormBody.Builder()
            .add("grant_type", "client_credentials")
            .build();
        Request request = new Request.Builder()
            .url("https://api.sandbox.paypal.com/v1/oauth2/token")
            .post(formBody)
            .build();

        try (Response response = client.newCall(request).execute()) {
          if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

         
          JSONObject json = JSONObject.parseObject(response.body().string());
          
          

          System.out.println("  scope ========" + json.getString("scope"));
          System.out.println("  access_token ========" + json.getString("access_token"));
          System.out.println("  token_type ========" + json.getString("token_type"));
          System.out.println("  app_id ========" + json.getString("app_id"));
          System.out.println("  expires_in ========" + json.getString("expires_in"));
          System.out.println("  nonce ========" + json.getString("nonce"));
        }
      
        
    }
}
