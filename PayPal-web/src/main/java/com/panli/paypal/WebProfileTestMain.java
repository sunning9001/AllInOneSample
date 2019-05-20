/**
 * @CreateTime: sunning2019年3月21日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.panli.paypal;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * @author sunning
 * @date 2019/03/21
 */
public class WebProfileTestMain {

    public static void main(String[] args) throws IOException {

        
        OkHttpClient client = new OkHttpClient();
        
        
        Request request = new Request.Builder()
            .url("https://api.sandbox.paypal.com/v1/payment-experience/web-profiles/XP-8YTH-NNP3-WSVN-3C76")
            .addHeader("Authorization" ,"Bearer " + "A21AAHCqH0EohG3a4Xr-iFqTLDgC27tqGUaSD85m09R8F5FqbunfvVvI8P6V6S6_bUwuNJkGUTmQkIq79M1JUJihM6Sl_OENQ")
            .addHeader("Content-Type", "application/json")
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
