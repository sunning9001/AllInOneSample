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

import com.alibaba.fastjson.JSONObject;
import com.panli.wechat.res.RefundQueryResponse;
import com.panli.wechat.res.ResponseUtil;
import com.panli.wechat.util.WXPay;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 查询退款 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_5
 * https://api.mch.weixin.qq.com/pay/refundquery
 * 
 * @author sunning
 *
 */
@Api(value = "微信查询退款", tags = { "微信查询退款" })
@RestController
public class WechatRefundQueryControl {

	private final Logger logger = LoggerFactory.getLogger(WechatRefundQueryControl.class);

	@Autowired
	private WXPay wxpay;

	private String TRANSACTION_ID = "transaction_id";// 微信订单号
	private String OUT_TRADE_NO = "out_trade_no";// 商户订单号
	private String TOTAL_FEE = "total_fee";// 订单金额
	private String CASH_FEE = "cash_fee";// 现金支付金额
	private String REFUND_COUNT = "refund_count";// 退款笔数
	private String OUT_REFUND_NO = "out_refund_no";// 商户退款单号
	private String REFUND_ID = "refund_id";// 微信退款单号
	private String REFUND_FEE = "refund_fee";// 申请退款金额
	private String REFUND_STATUS = "refund_status";// 退款状态
	private String REFUND_RECV_ACCOUT = "refund_recv_accout";// 退款入账账户
	private String REFUND_SUCCESS_TIME = "refund_success_time";// 退款成功时间

	/**
	 * 
	 * @param subject
	 * @param response
	 */
	@ApiOperation(value = "wechat_refundQuery", notes = "微信申请退款")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "transaction_id", value = "微信订单号 ", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "out_trade_no", value = "商户订单号", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "out_refund_no", value = "商户退款单号", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "refund_id", value = "微信退款单号", dataType = "String", paramType = "query"),

	})
	@RequestMapping(value = "/wechat_refundQuery", method = RequestMethod.GET)
	public RefundQueryResponse wechat_refundQuery(
			@RequestParam(value = "transaction_id", required = false) String transaction_id, // 微信订单号
			@RequestParam(value = "out_trade_no", required = false) String out_trade_no, // 商户订单号
			@RequestParam(value = "out_refund_no", required = false) String out_refund_no, // 商户退款单号
			@RequestParam(value = "refund_id", required = false) String refund_id // 微信退款单号

	) {

		logger.debug("wechat_refundQuery ");
		
		RefundQueryResponse  response =new RefundQueryResponse();
		response.setCode(ResponseUtil.DEFAULT_FAIL_CODE);
		response.setMsg(ResponseUtil.DEFAULT_FAIL_MSG);

		Map<String, String> reqData = new HashMap<>();
		if (transaction_id != null)
			// 微信订单号
			reqData.put("transaction_id", transaction_id);
		if (out_trade_no != null)
			// 商户订单号
			reqData.put("out_trade_no", out_trade_no);
		if (out_refund_no != null)
			// 商户退款单号
			reqData.put("out_refund_no", out_refund_no);
		if (refund_id != null)
			// 微信退款单号
			reqData.put("refund_id", refund_id);

		try {
			Map<String, String> resMap = wxpay.refundQuery(reqData);
			ResponseUtil.allocateReturnRes(response, resMap);
			
			response.setTransaction_id(resMap.get(TRANSACTION_ID));
			response.setOut_trade_no(resMap.get(OUT_TRADE_NO));
			response.setTotal_fee(resMap.get(TOTAL_FEE));
			response.setCash_fee(resMap.get(CASH_FEE));
			response.setRefund_count(resMap.get(REFUND_COUNT));
			response.setOut_refund_no(resMap.get(OUT_REFUND_NO));
			response.setRefund_id(resMap.get(REFUND_ID));
			response.setRefund_fee(resMap.get(REFUND_FEE));
			response.setRefund_status(resMap.get(REFUND_STATUS));
			response.setRefund_recv_accout(resMap.get(REFUND_RECV_ACCOUT));
			response.setRefund_success_time(resMap.get(REFUND_SUCCESS_TIME));

			logger.debug("wechat_refundQuery result :{} ", JSONObject.toJSONString(resMap));

		} catch (Exception e) {
			logger.debug("wechat_refundQuery exception : {} ", e);
			response.setMsg(e.getMessage());
		}
		return response;
	}
}
