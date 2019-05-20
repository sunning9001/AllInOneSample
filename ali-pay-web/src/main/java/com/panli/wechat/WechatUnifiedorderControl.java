package com.panli.wechat;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panli.wechat.res.ResponseUtil;
import com.panli.wechat.res.UnifiedorderResponse;
import com.panli.wechat.util.WXPay;
import com.panli.wechat.util.WXPayUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 微信统一下单 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
 * https://api.mch.weixin.qq.com/pay/unifiedorder
 * 
 * @author sunning
 *
 */
@Api(value = "微信统一下单", tags = { "微信统一下单" })
@RestController
public class WechatUnifiedorderControl {

	private final Logger logger = LoggerFactory.getLogger(WechatUnifiedorderControl.class);

	@Autowired
	private WXPay wxpay;
	@Autowired
	private WXPayConfigImpl    wxpayConfigImpl;
	
	private static final String TRADE_TYPE = "trade_type";
	private static final String PREPAY_ID = "prepay_id";
	private static final String CODE_URL = "code_url";

	/**
	 * 
	 * @param subject
	 * @param response
	 */
	@ApiOperation(value = "wechat_unifiedOrder", notes = "微信统一下单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "body", value = "商品描述", dataType = "String", paramType = "query", required = true),
			@ApiImplicitParam(name = "out_trade_no", value = "商户订单号", dataType = "String", paramType = "query", required = true),
			@ApiImplicitParam(name = "total_fee", value = "订单总金额，单位为分", dataType = "int", paramType = "query", required = true),
			@ApiImplicitParam(name = "trade_type", value = "交易类型", dataType = "String", paramType = "query", required = true),
			@ApiImplicitParam(name = "spbill_create_ip", value = "终端IP", dataType = "String", paramType = "query", required = true),
			@ApiImplicitParam(name = "notify_url", value = "内部通知地址", dataType = "String", paramType = "query", required = true),
			@ApiImplicitParam(name = "attach", value = "附加数据，在查询API和支付通知中原样返回", dataType = "String", paramType = "query", required = false),

	})
	@RequestMapping(value = "/wechat_unifiedOrder", method = RequestMethod.GET)
	public UnifiedorderResponse wechat_unifiedOrder(@RequestParam(value = "body",required =true) String body, // 商品描述
			@RequestParam(value = "out_trade_no",required =true) String out_trade_no, // 商户订单号
			@RequestParam(value = "total_fee",required =true) String total_fee, // 订单总金额，单位为分
			@RequestParam(value = "trade_type",required =true) String trade_type, // 交易类型
			@RequestParam(value = "spbill_create_ip",required =true) String spbill_create_ip, // 终端IP
			@RequestParam(value = "notify_url",required =true) String notify_url ,//内部通知地址
			@RequestParam(value = "attach",required =false) String attach //附加数据，在查询API和支付通知中原样返回
			
	) {

		logger.debug("wechat_unifiedOrder ");
		
		UnifiedorderResponse response =new UnifiedorderResponse();
		response.setCode(ResponseUtil.DEFAULT_FAIL_CODE);
		response.setMsg(ResponseUtil.DEFAULT_FAIL_MSG);

		Map<String, String> reqData = new HashMap<>();

		try {

			// 商品描述
			reqData.put("body", body);
			// 商户订单号
			reqData.put("out_trade_no", out_trade_no);
			// 标价金额 total_fee
			reqData.put("total_fee", total_fee);
			// 终端IP spbill_create_ip
			reqData.put("spbill_create_ip", spbill_create_ip);
			// 通知地址 notify_url
			reqData.put("notify_url",wxpayConfigImpl.getNotifyUrl());
			// 交易类型 trade_type
			if (TRADE_TYPE != null) {
				reqData.put("trade_type", trade_type);
			} else {
				reqData.put("trade_type", "NATIVE");
			}
			if(attach!=null) {
				reqData.put("attach", attach);
			}

			Map<String, String> resMap = wxpay.unifiedOrder(reqData);
			
			
			ResponseUtil.allocateReturnRes(response, resMap);
			
			response.setCode_url(resMap.get(CODE_URL));
			response.setPrepay_id(resMap.get(PREPAY_ID));
			response.setTrade_type(resMap.get(TRADE_TYPE));

			logger.debug("wechat_unifiedOrder result :{} ", WXPayUtil.mapToXml(resMap));
		} catch (Exception e) {
			logger.debug("wechat_unifiedOrder exception : {} ", e);
			response.setMsg(e.getMessage());
		}
		return response;
	}
}
