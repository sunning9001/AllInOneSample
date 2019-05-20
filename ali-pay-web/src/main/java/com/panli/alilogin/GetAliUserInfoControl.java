/**
@CreateTime: sunning2019年3月18日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

package com.panli.alilogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.panli.alipay.util.AlipayConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 获取支付用户信息
 * 
 * @author sunning
 * @date 2019/03/18
 */
@Api(value="登录信息接口",tags= {"登录信息接口"})
@RestController
public class GetAliUserInfoControl {
	private final Logger logger = LoggerFactory.getLogger(GetAliUserInfoControl.class);

	@ApiOperation(value="GetAliUserInfo",notes= "获取支付用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name="token",value="token",dataType="String", paramType = "query",required=true),      
    })
	@RequestMapping(value = "/getAliUserInfo", method = RequestMethod.GET)
	public String getAliUserInfo(@RequestParam(value = "token") String token) {

		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayUserInfoShareRequest aliRequest = new AlipayUserInfoShareRequest();

		try {
			AlipayUserInfoShareResponse response = alipayClient.execute(aliRequest, token);

			logger.debug("GetAliUserInfo  AlipayUserInfoShareResponse :{}", JSONObject.toJSONString(response));

		} catch (AlipayApiException e) {
			logger.debug("GetAliUserInfo  AlipayApiException :{}", e);
		}
		return null;
	}
}
