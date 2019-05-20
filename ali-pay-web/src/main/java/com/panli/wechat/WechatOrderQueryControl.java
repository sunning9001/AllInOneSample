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

import com.panli.wechat.res.OrderqueryResponse;
import com.panli.wechat.res.ResponseUtil;
import com.panli.wechat.util.WXPay;
import com.panli.wechat.util.WXPayUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 支付接口 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2
 * https://api.mch.weixin.qq.com/pay/orderquery
 * 
 * @author sunning
 *
 */
@Api(value = "微信查询订单", tags = { "微信查询订单" })
@RestController
public class WechatOrderQueryControl {

	private final Logger logger = LoggerFactory.getLogger(WechatOrderQueryControl.class);

	private String OPENID = "openid";// 用户标识是
	private String IS_SUBSCRIBE = "is_subscribe";// 是否关注公众账号是
	private String TRADE_TYPE = "trade_type";// 交易类型 是
	private String TRADE_STATE = "trade_state";// 交易状态是
	private String BANK_TYPE = "bank_type";// 付款银行 是
	private String TOTAL_FEE = "total_fee";// 标价金额是
	private String CASH_FEE = "cash_fee";// 现金支付金额是
	private String TRANSACTION_ID = "transaction_id";// 微信支付订单号是
	private String OUT_TRADE_NO = "out_trade_no";// 商户订单号是
	private String TIME_END = "time_end";// 支付完成时间是
	private String TRADE_STATE_DESC = "trade_state_desc";// 交易状态描述是

	@Autowired
	private WXPay wxpay;

	/**
	 * 
	 * @param subject
	 * @param response
	 */
	@ApiOperation(value = "wechat_orderQuery", notes = "微信查询订单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "transaction_id", value = "微信订单号 ", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "out_trade_no", value = "商家订单号", dataType = "String", paramType = "query"), })
	@RequestMapping(value = "/wechat_orderQuery", method = RequestMethod.GET)
	public OrderqueryResponse wechat_orderQuery(
			@RequestParam(value = "transaction_id", required = false) String transaction_id, // 微信订单号
			@RequestParam(value = "out_trade_no", required = false) String out_trade_no // 商户订单号
	) {

		logger.debug("wechat_orderQuery ");
		OrderqueryResponse response = new OrderqueryResponse();
		response.setCode(ResponseUtil.DEFAULT_FAIL_CODE);
		response.setMsg(ResponseUtil.DEFAULT_FAIL_MSG);

		Map<String, String> reqData = new HashMap<>();
		// 商品描述
		if (transaction_id != null)
			reqData.put("transaction_id", transaction_id);
		// 商户订单号
		if (out_trade_no != null)
			reqData.put("out_trade_no", out_trade_no);

		try {
			Map<String, String> resMap = wxpay.orderQuery(reqData);

			ResponseUtil.allocateReturnRes(response, resMap);

			response.setOpenid(resMap.get(OPENID));
			response.setIs_subscribe(resMap.get(IS_SUBSCRIBE));
			response.setTrade_type(resMap.get(TRADE_TYPE));
			response.setTrade_state(resMap.get(TRADE_STATE));
			response.setBank_type(resMap.get(BANK_TYPE));
			response.setTotal_fee(resMap.get(TOTAL_FEE));
			response.setCash_fee(resMap.get(CASH_FEE));
			response.setTransaction_id(resMap.get(TRANSACTION_ID));
			response.setOut_trade_no(resMap.get(OUT_TRADE_NO));
			response.setTime_end(resMap.get(TIME_END));
			response.setTrade_state_desc(resMap.get(TRADE_STATE_DESC));

			logger.debug("wechat_orderQuery result :{} ", WXPayUtil.mapToXml(resMap));
		} catch (Exception e) {
			logger.debug("wechat_orderQuery exception : {} ", e);
		}
		return response;
	}
}
