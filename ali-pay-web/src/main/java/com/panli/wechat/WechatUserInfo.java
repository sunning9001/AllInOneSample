/**
@CreateTime: sunning2019年3月18日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

 package com.panli.wechat;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author sunning
 * @date 2019/03/18
 */
public class WechatUserInfo {

    public static void main(String[] args) throws IOException {
        

        
        final OkHttpClient client = new OkHttpClient();

        //"access_token":"19_1tUI0ZbdS6IQdTx8b3Cvmb731UBr3irmvuR9lZ0wn6ROTQhHcDPIptO0FXw2eXl0ptrx5rAnD5CA464F8YYbKQ"
        //"openid":"ouJf6wOu6kB2ePmKIXEfiHVADL8Y"
        String url ="https://api.weixin.qq.com/sns/userinfo?access_token=19_1tUI0ZbdS6IQdTx8b3Cvmb731UBr3irmvuR9lZ0wn6ROTQhHcDPIptO0FXw2eXl0ptrx5rAnD5CA464F8YYbKQ&openid=ouJf6wOu6kB2ePmKIXEfiHVADL8Y";

        Request request = new Request.Builder()
            .url(url)
            .build();

        try (Response response = client.newCall(request).execute()) {
          if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

          Headers responseHeaders = response.headers();
          for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
          }

          System.out.println(response.body().string());
        }
      
   
    }
}
