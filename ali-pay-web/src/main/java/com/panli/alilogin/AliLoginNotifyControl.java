/**
@CreateTime: sunning2019年3月18日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

package com.panli.alilogin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.panli.alipay.util.AlipayConfig;

/**
 * URL 拼接
 * https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2016031701220615&scope=auth_user&redirect_uri=http%3A%2F%2Ftest.ngrok.yugyg.com%3A8000%2Falilogin_loginNotify&state=init
 * 
 * @author sunning
 * @date 2019/03/18
 */
@RestController
public class AliLoginNotifyControl {
	
	private Logger logger =LoggerFactory.getLogger(AliLoginNotifyControl.class);

	private static final String    AUTH_CODE="auth_code";
	@RequestMapping("/alilogin_loginNotify")
	public void alilogin_loginNotify( WebRequest request) {

		Map<String, String> parametersMap = new HashMap<>();
		Iterator<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasNext()) {
			String parameterName = parameterNames.next();
			parametersMap.putIfAbsent(parameterName, request.getParameter(parameterName));

		}
		logger.debug("alilogin_loginNotify  parameters : {}" ,JSONObject.toJSONString(parametersMap));
		
		
		String authCode = parametersMap.get(AUTH_CODE);
		
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		AlipaySystemOauthTokenRequest alipayRequest = new AlipaySystemOauthTokenRequest();
		alipayRequest.setCode(authCode);
		alipayRequest.setGrantType("authorization_code");
		try {
		    AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(alipayRequest);
		    
		    //处理access  refress  access
			logger.debug("alilogin_loginNotify  oauthTokenResponse : {}" ,JSONObject.toJSONString(oauthTokenResponse));
		    
		} catch (AlipayApiException e) {
		    //处理异常
			logger.debug("alipay_tradeQuery  AlipayApiException :{}",e );
		}
		
		
	}
}
