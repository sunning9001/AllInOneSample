/**
@CreateTime: sunning2019年3月18日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

package com.panli.wechat;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.panli.wechat.util.WXPayConstants.SignType;
import com.panli.wechat.util.WXPayUtil;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author sunning
 * @date 2019/03/18
 */
@RestController
public class WechatPayNotifyControl {
	private static final Logger logger = LoggerFactory.getLogger(WechatPayNotifyControl.class);

	/**
	 * 微信支付订单号在redis中键的前缀
	 */
	private final String WECHAT_PAY__TRANSACTION_ID = "WECHAT_PAY__TRANSACTION_ID";
	/**
	 * 
	 */
	private final String TRANSACTION_ID = "transaction_id";

	@Autowired
	private JedisPool jedisPool;

	@RequestMapping("/wechat_test")
	public void wechat_test(HttpEntity<String> entity) {
		String body = entity.getBody();
		logger.debug("wechat_pay_notify  body :" + body);
		Jedis jedis = null;

		try {
			Map<String, String> weixinData = WXPayUtil.xmlToMap(body);
			if (WXPayUtil.isSignatureValid(weixinData, "dOy11xkwDOOra401s8A8KYsSyusU1Dug", SignType.HMACSHA256)) {
				// 判断是否通知过
				String transactionId = weixinData.get(TRANSACTION_ID);
				if (transactionId != null) {

					jedis = jedisPool.getResource();
					String parameterJson = jedis.get(WECHAT_PAY__TRANSACTION_ID + transactionId);
					// 第一次通知
					if (parameterJson == null) {
						jedis.set(WECHAT_PAY__TRANSACTION_ID + transactionId, JSONObject.toJSONString(weixinData));
						logger.debug(" wechat_pay_notify   find transaction id   set  to  redis , key = {} ,value ={ }",
								WECHAT_PAY__TRANSACTION_ID + transactionId, JSONObject.toJSONString(weixinData));
						// 通知wechat pay success
						notifyInnerApplication( weixinData, "http://192.168.0.98:8081/app/memberTrade/rechargeWxCall");
					} else {
						// 多次通知
						logger.debug(" wechat_pay_notify find transaction id in redis , key = {} ,value ={ }",
								WECHAT_PAY__TRANSACTION_ID + transactionId, parameterJson);
					}
				} else {
					logger.debug(" wechat_pay_notify   transactionId is  null ");
				}

			} else {
				logger.debug(" signature is  not valid ");

			}
		} catch (Exception e) {

			logger.debug(" wechat_pay_notify parse  xmlToMap exception : {} ", e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	/**
	 * form 表单  键值
	 */
	private static final String RES_APPFORMKEY ="data";
	
	/**
	 * 把微信支付消息通知到内部应用程序
	 * 
	 * @param weixinData
	 */
	public static void notifyInnerApplication(Map<String, String> weixinData, String nitifyInnerUrl) {
		

			OkHttpClient client = new OkHttpClient();
	
			RequestBody formBody = new FormBody.Builder()
					.add(RES_APPFORMKEY, JSONObject.toJSONString(weixinData))
					.build();
			Request request = new Request
					.Builder()
					.url(nitifyInnerUrl)
					.post(formBody).build();
			client.newCall(request).enqueue(new Callback() {
	
				@Override
				public void onResponse(Call call, Response response) throws IOException {
					
				  logger.debug("notifyInnerApplication  onResponse Success {}",call.request().body());
				}
	
				@Override
				public void onFailure(Call call, IOException e) {
					logger.debug("notifyInnerApplication  onFailure request:{}  IOException: {}",call.request().body(),e);
	
				}});

	}
}
