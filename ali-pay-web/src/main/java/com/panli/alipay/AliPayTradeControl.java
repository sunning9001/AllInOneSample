package com.panli.alipay;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

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
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.panli.alipay.util.AlipayConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * https://docs.open.alipay.com/270
 * 电脑网站支付
 * https://docs.open.alipay.com/203
 * 支付宝手机网站支付
 * 
 * 支付接口
 * 
 * @author sunning
 *
 */
@Api(value = "支付宝统一收单下单并支付页面接口", tags = { "支付宝统一收单下单并支付页面接口" })
@RestController
public class AliPayTradeControl {

	private final Logger  logger =LoggerFactory.getLogger(AliPayTradeControl.class);
    /**
     * 
     * @param subject
     * @param response
     */
	
	@ApiOperation(value = "alipay_trade", notes = "支付宝统一收单下单并支付页面接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "subject", value = "商品的标题", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "out_trade_no", value = "商户网站唯一订单号", dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "total_amount", value = "订单总金额，单位为元", dataType = "Double", paramType = "query"), 
			})
	@RequestMapping(value = "/alipay_trade", method = RequestMethod.GET)
	public void alipay_trade(@RequestParam(value = "subject",required =true) String subject, //商品的标题
			@RequestParam(value = "out_trade_no",required =true) String out_trade_no, //商户网站唯一订单号
			@RequestParam(value = "total_amount",required =true) Double total_amount, //商户网站唯一订单号
			HttpServletResponse response) {
		
		logger.debug("alipay_trade ");

		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		JSONObject json = new JSONObject();

		json.put("out_trade_no", out_trade_no);
		json.put("total_amount", total_amount);
		json.put("subject", subject);
		json.put("product_code", "FAST_INSTANT_TRADE_PAY");
		json.put("integration_type", "ALIAPP");


		alipayRequest.setBizContent(json.toJSONString());

		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

		try {

			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(form);// 直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
