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
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.panli.alipay.res.AliPayRefundReturnRes;
import com.panli.alipay.util.AliResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * https://docs.open.alipay.com/api_1/alipay.trade.refund
 * 统一收单交易退款接口
 * 
 * @author sunning
 *
 */
@Api(value = "统一收单交易退款接口", tags = { "统一收单交易退款接口" })
@RestController
public class AliRefundControl {

	private final Logger  logger =LoggerFactory.getLogger(AliRefundControl.class);
	
	@Autowired
	private AlipayClient alipayClient ;
    /**
     * 
     * @param subject
     * @param response
     */
	
	@ApiOperation(value = "alipay_refund", notes = "统一收单交易退款接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trade_no", value = "支付宝交易号", dataType = "String", paramType = "query", required = false),
			@ApiImplicitParam(name = "out_trade_no", value = "商家订单号", dataType = "String", paramType = "query", required = false),
			@ApiImplicitParam(name = "refund_amount", value = "退款的金额-,单位为元，支持两位小数 ", dataType = "String", paramType = "query", required = true),
			@ApiImplicitParam(name = "out_request_no", value = "标识一次退款请求", dataType = "String", paramType = "query", required = false)
			})

	@RequestMapping(value = "/alipay_refund", method = RequestMethod.GET)
	public AliPayRefundReturnRes alipay_refund(@RequestParam(value = "out_trade_no",required =false) String out_trade_no,
			@RequestParam(value = "trade_no",required =false) String trade_no,
			@RequestParam(value = "refund_amount",required =true) String refund_amount,
			@RequestParam(value = "out_request_no",required =false) String out_request_no
			) {

	   
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
		
		AliPayRefundReturnRes response =new AliPayRefundReturnRes();
		response.setCode(AliResponseUtil.DEFAULT_FAIL_CODE);
		response.setMsg(AliResponseUtil.DEFAULT_FAIL_MSG);

		JSONObject json = new JSONObject();
		//商户订单号，商户网站订单系统中唯一订单号
		json.put("out_trade_no", out_trade_no);
	    //支付宝交易号
		json.put("trade_no", trade_no);
		//需要退款的金额，该金额不能大于订单金额，必填
		json.put("refund_amount", refund_amount);
		//退款的原因说明
		//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传				
		json.put("out_request_no", out_request_no);
		alipayRequest.setBizContent(json.toJSONString());

		//请求
		try {
			AlipayTradeRefundResponse result = alipayClient.execute(alipayRequest);
			
			AliResponseUtil.allocateReturnRes(result, response);
			
			response.setTrade_no(result.getTradeNo());
			response.setOut_trade_no(result.getOutTradeNo());
			response.setBuyer_logon_id(result.getBuyerLogonId());
			response.setFund_change(result.getFundChange());
			response.setRefund_fee(result.getRefundFee());
		    response.setGmt_refund_pay(result.getGmtRefundPay());
		    response.setBuyer_user_id(result.getBuyerUserId());

			
			logger.debug("alipay_refund execute result : {}",result);
		} catch (AlipayApiException e) {
			logger.debug("alipay_refund  AlipayApiException :{}",e );
			response.setCode(AliResponseUtil.DEFAULT_FAIL_CODE);
			response.setMsg(e.getMessage());
		}
		
		return response;
	}
}
