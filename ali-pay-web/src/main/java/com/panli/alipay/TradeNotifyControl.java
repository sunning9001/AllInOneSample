package com.panli.alipay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.panli.alipay.util.AlipayConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
public class TradeNotifyControl {

	/**
	 * notify_id 在redis的存储键
	 */
	private final String ALIPAY_NOTIFY_ID = "ALIPAY_NOTIFY_ID";
	/**
	 * 通知校验Id
	 */
	private final String parameter_notify_id = "notify_id";

	@Autowired
	private JedisPool jedisPool;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(TradeNotifyControl.class);

	/**
	 * 支付宝异步回调接口
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping("/trade_notify")
	public void trade_notify(HttpServletResponse response, WebRequest request) {

		Map<String, String> parametersMap = new HashMap<>();
		Iterator<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasNext()) {
			String parameterName = parameterNames.next();
			parametersMap.putIfAbsent(parameterName, request.getParameter(parameterName));
		}
		logger.debug(" trade_notify  jsonString :{}", JSONObject.toJSON(parametersMap));

		// 调用SDK验证签名
		boolean signVerified;
		Jedis jedis = null;
		try {
			signVerified = AlipaySignature.rsaCheckV1(parametersMap, AlipayConfig.alipay_public_key,
					AlipayConfig.charset, AlipayConfig.sign_type);
			// 验证签名成功
			if (signVerified) {
				// 判断是否已经处理该消息
				String parameterNotifyId = parametersMap.get(parameter_notify_id);
				if (parameterNotifyId != null) {
					jedis = jedisPool.getResource();
					String parameterJson = jedis.get(ALIPAY_NOTIFY_ID + parameterNotifyId);
					//第一次通知
					if(parameterJson ==null) {
						jedis.set(ALIPAY_NOTIFY_ID + parameterNotifyId,  JSONObject.toJSONString(parametersMap));
						logger.debug(" trade_notify  set  to  redis , key = {} ,value ={ }",parameterNotifyId,parameterJson);
					    //通知alipay success
						response.getOutputStream().write("success".getBytes());
						response.getOutputStream().flush();
						response.getOutputStream().close();
					}else {
						//多次通知
						logger.debug(" trade_notify find notify id in redis , key = {} ,value ={ }",parameterNotifyId,parameterJson);
					}
				} else {
					logger.debug(" trade_notify  parse  error, can not  find notify id");
				}
			
			} else {

				// 记录验证签名失败
				logger.debug(" trade_notify  Verified  Fail :{}", JSONObject.toJSON(parametersMap));
			}
		} catch (AlipayApiException e) {
			logger.debug(" trade_notify  AlipayApiException :{}", e);
		} catch (IOException e) {
			logger.debug(" trade_notify  IOException :{}", e);
		}finally {
			if(jedis!=null) {
				jedis.close();
			}
		}

	}
}
