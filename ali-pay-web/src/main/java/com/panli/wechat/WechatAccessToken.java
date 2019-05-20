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
public class WechatAccessToken {

    public static void main(String[] args) throws IOException {
        
         final OkHttpClient client = new OkHttpClient();

         String url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx59e5e447bc5fadf9&secret=7349bf534ad22d82ce4716483144df9d&code=061hlOfe2HkmlG0yWkie2ytSfe2hlOfq&grant_type=authorization_code";

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
