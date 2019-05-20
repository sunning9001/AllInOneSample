package com.panli.alipay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.panli.alipay.res.AliPayTradeQueryReturnRes;
import com.panli.alipay.util.AliResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * https://docs.open.alipay.com/203 手机网站支付
 * 
 * 支付接口
 * 
 * @author sunning
 *
 */
@Api(value = "支付宝统一收单线下交易查询 ", tags = { "支付宝统一收单线下交易查询 " })
@RestController
public class AliTradeQueryControl {

	private final Logger logger = LoggerFactory.getLogger(AliTradeQueryControl.class);

	@Autowired
	private AlipayClient alipayClient;

	/**
	 * 
	 * @param subject
	 * @param response
	 */
	@ApiOperation(value = "alipay_tradeQuery", notes = "支付宝统一收单线下交易查询 ")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trade_no", value = "支付宝交易号", dataType = "String", paramType = "query", required = false),
			@ApiImplicitParam(name = "out_trade_no", value = "商家订单号", dataType = "String", paramType = "query", required = false) })

	@RequestMapping(value = "/alipay_tradeQuery", method = RequestMethod.GET)
	public AliPayTradeQueryReturnRes alipay_tradeQuery(
			@RequestParam(value = "trade_no", required = false) String trade_no, // 支付宝交易号
			@RequestParam(value = "out_trade_no", required = false) String out_trade_no// 商家订单号
	) {

		logger.debug("alipay_tradeQuery ");

		// 设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

		AliPayTradeQueryReturnRes response = new AliPayTradeQueryReturnRes();
		response.setCode(AliResponseUtil.DEFAULT_FAIL_CODE);
		response.setMsg(AliResponseUtil.DEFAULT_FAIL_MSG);

		JSONObject json = new JSONObject();
		if (trade_no != null)
			json.put("trade_no", trade_no);
		if (out_trade_no != null)
			json.put("out_trade_no", out_trade_no);

		alipayRequest.setBizContent(json.toJSONString());
		try {

			AlipayTradeQueryResponse result = alipayClient.execute(alipayRequest);

			AliResponseUtil.allocateReturnRes(result, response);
			response.setOut_trade_no(result.getOutTradeNo());
			response.setTrade_status(result.getTradeStatus());
			response.setTotal_amount(result.getTotalAmount());
			response.setBuyer_logon_id(result.getBuyerLogonId());

			logger.debug("alipay_tradeQuery execute result : {}", result);
		} catch (AlipayApiException e) {

			logger.debug("alipay_tradeQuery  AlipayApiException :{}", e);
			response.setCode(AliResponseUtil.DEFAULT_FAIL_CODE);
			response.setMsg(e.getMessage());
		}
		return response;
	}
}
