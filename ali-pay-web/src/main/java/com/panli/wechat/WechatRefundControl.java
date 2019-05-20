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

import com.panli.wechat.res.RefundResponse;
import com.panli.wechat.res.ResponseUtil;
import com.panli.wechat.util.WXPay;
import com.panli.wechat.util.WXPayUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 申请退款 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4
 * https://api.mch.weixin.qq.com/secapi/pay/refund
 * 
 * @author sunning
 *
 */
@Api(value = "微信申请退款", tags = { "微信申请退款" })
@RestController
public class WechatRefundControl {

	private final Logger logger = LoggerFactory.getLogger(WechatRefundControl.class);

	private String TRANSACTION_ID = "transaction_id";// 微信订单号 是
	private String OUT_TRADE_NO = "out_trade_no";// 商户订单号 是
	private String OUT_REFUND_NO = "out_refund_no";// 商户退款单号 是
	private String REFUND_ID = "refund_id";// 微信退款单号 是
	private String REFUND_FEE = "refund_fee";// 退款金额 是
	private String TOTAL_FEE = "total_fee";// 标价金额 是
	private String CASH_FEE = "cash_fee";// 现金支付金额 是

	@Autowired
	private WXPay wxpay;

	/**
	 * 
	 * @param subject
	 * @param response
	 */
	@ApiOperation(value = "wechat_refund", notes = "微信申请退款")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "transaction_id", value = "微信订单号 ", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "out_trade_no", value = "商家订单号", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "out_refund_no", value = "商户退款单号", dataType = "String", paramType = "query", required = true),
			@ApiImplicitParam(name = "total_fee", value = "订单金额", dataType = "int", paramType = "query", required = true),
			@ApiImplicitParam(name = "refund_fee", value = "退款金额", dataType = "int", paramType = "query", required = true), })
	@RequestMapping(value = "/wechat_refund", method = RequestMethod.GET)
	public RefundResponse wechat_refund(@RequestParam(value = "transaction_id", required = false) String transaction_id, // 微信订单号
			@RequestParam(value = "out_trade_no", required = false) String out_trade_no, // 商户订单号
			@RequestParam(value = "out_refund_no") String out_refund_no, // 商户退款单号
			@RequestParam(value = "total_fee") String total_fee, // 订单金额
			@RequestParam(value = "refund_fee") String refund_fee // 退款金额
	) {

		logger.debug("wechat_refund ");

		RefundResponse response = new RefundResponse();
		response.setCode(ResponseUtil.DEFAULT_FAIL_CODE);
		response.setCode(ResponseUtil.DEFAULT_FAIL_MSG);

		Map<String, String> reqData = new HashMap<>();
		// 微信订单号
		reqData.put("transaction_id", transaction_id);
		// 商户订单号
		reqData.put("out_trade_no", out_trade_no);
		// 商户退款单号
		reqData.put("out_refund_no", out_refund_no);
		// 订单金额
		reqData.put("total_fee", total_fee);
		// 退款金额
		reqData.put("refund_fee", refund_fee);

		try {
			Map<String, String> resMap = wxpay.refund(reqData);

			ResponseUtil.allocateReturnRes(response, resMap);
			response.setTransaction_id(resMap.get(TRANSACTION_ID));
			response.setOut_trade_no(resMap.get(OUT_TRADE_NO));
			response.setOut_refund_no(resMap.get(OUT_REFUND_NO));
			response.setRefund_id(resMap.get(REFUND_ID));
			response.setRefund_fee(resMap.get(REFUND_FEE));
			response.setTotal_fee(resMap.get(TOTAL_FEE));
			response.setCash_fee(resMap.get(CASH_FEE));

			logger.debug("wechat_refund result :{} ", WXPayUtil.mapToXml(resMap));

		} catch (Exception e) {
			logger.debug("wechat_refund exception : {} ", e);
			response.setCode(e.getMessage());

		}
		return response;

	}
}
