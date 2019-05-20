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
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.panli.alipay.res.AliPayTradeQueryReturnRes;
import com.panli.alipay.util.AliResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "支付宝 统一收单交易退款查询", tags = { "支付宝 统一收单交易退款查询" })
@RestController
public class AliRefundQueryControl {

	private final Logger logger = LoggerFactory.getLogger(AliRefundQueryControl.class);
	
	@Autowired
	public AlipayClient alipayClient;

	/**
	 * 
	 * @param subject
	 * @param response
	 */
	@ApiOperation(value = "alipay_refundQuery", notes = "支付宝 统一收单交易退款查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trade_no", value = "支付宝交易号", dataType = "String", paramType = "query", required = false),
			@ApiImplicitParam(name = "out_trade_no", value = "商家订单号", dataType = "String", paramType = "query", required = false),
			@ApiImplicitParam(name = "out_request_no", value = "标识一次退款请求", dataType = "String", paramType = "query", required = true) })
	@RequestMapping(value = "/alipay_refundQuery", method = RequestMethod.GET)
	public AliPayTradeQueryReturnRes alipay_refundQuery(@RequestParam(value = "trade_no", required = false) String trade_no,
			@RequestParam(value = "out_trade_no", required = false) String out_trade_no,
			@RequestParam(value = "out_request_no", required = true) String out_request_no) {

		
		AliPayTradeQueryReturnRes  response =new AliPayTradeQueryReturnRes();
		response.setCode(AliResponseUtil.DEFAULT_FAIL_CODE);
		response.setMsg(AliResponseUtil.DEFAULT_FAIL_MSG);
		
		AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();

		JSONObject json = new JSONObject();
		// 商户订单号，商户网站订单系统中唯一订单号
		if (trade_no!=null)
			json.put("trade_no", trade_no);
		if (out_trade_no!=null)
			json.put("out_trade_no", out_trade_no);
		json.put("out_request_no", out_request_no);

		alipayRequest.setBizContent(json.toJSONString());

		// 请求
		try {
			AlipayTradeFastpayRefundQueryResponse result = alipayClient.execute(alipayRequest);

			AliResponseUtil.allocateReturnRes(result, response);
			
			logger.debug("alipay_refundQuery execute result : {}", result);
		} catch (AlipayApiException e) {

			logger.debug("alipay_refundQuery  AlipayApiException :{}", e);
			response.setCode(AliResponseUtil.DEFAULT_FAIL_CODE);
			response.setMsg(e.getMessage());
		}
        return  response;
	}
}
