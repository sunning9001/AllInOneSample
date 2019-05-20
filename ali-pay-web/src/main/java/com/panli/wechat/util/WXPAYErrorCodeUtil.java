package com.panli.wechat.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sunning
 *
 */
public class WXPAYErrorCodeUtil {

	public static final Map<String, String> errorMap =new HashMap<>();
	
	static {
		
	
		//https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
	    //统一下单错误吗		
		errorMap.put("INVALID_REQUEST","参数格式有误或者未按规则上传");
		errorMap.put("NOAUTH","商户未开通此接口权限");
		errorMap.put("NOTENOUGH","用户帐号余额不足");
		errorMap.put("ORDERPAID","商户订单已支付，无需重复操作");
		errorMap.put("ORDERCLOSED","当前订单已关闭，无法支付");
		errorMap.put("SYSTEMERROR","系统超时");
		errorMap.put("APPID_NOT_EXIST","参数中缺少APPID");
		errorMap.put("MCHID_NOT_EXIST","参数中缺少MCHID");
		errorMap.put("APPID_MCHID_NOT_MATCH","appid和mch_id不匹配");
		errorMap.put("LACK_PARAMS","缺少必要的请求参数");
		errorMap.put("OUT_TRADE_NO_USED","同一笔交易不能多次提交");
		errorMap.put("SIGNERROR","参数签名结果不正确");
		errorMap.put("XML_FORMAT_ERROR","XML格式错误");
		errorMap.put("REQUIRE_POST_METHOD","未使用post传递参数 ");
		errorMap.put("POST_DATA_EMPTY","post数据不能为空");
		errorMap.put("NOT_UTF8","未使用指定编码格式");
		
		//https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2
		//查询订单错误码
		errorMap.put("ORDERNOTEXIST","查询系统中不存在此交易订单号");
		errorMap.put("SYSTEMERROR","后台系统返回错误");
		
		//https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4
		//申请退款错误码
		errorMap.put("SYSTEMERROR","系统超时等");
		errorMap.put("BIZERR_NEED_RETRY","并发情况下，业务被拒绝，商户重试即可解决");
		errorMap.put("TRADE_OVERDUE","订单已经超过可退款的最大期限(支付后一年内可退款)");
		errorMap.put("ERROR","申请退款业务发生错误");
		errorMap.put("USER_ACCOUNT_ABNORMAL","用户帐号注销");
		errorMap.put("INVALID_REQ_TOO_MUCH","连续错误请求数过多被系统短暂屏蔽");
		errorMap.put("NOTENOUGH","商户可用退款余额不足");
		errorMap.put("INVALID_TRANSACTIONID","请求参数未按指引进行填写");
		errorMap.put("PARAM_ERROR","请求参数未按指引进行填写");
		errorMap.put("APPID_NOT_EXIST","参数中缺少APPID");
		errorMap.put("MCHID_NOT_EXIST","参数中缺少MCHID");
		errorMap.put("ORDERNOTEXIST","缺少有效的订单号");
		errorMap.put("REQUIRE_POST_METHOD","未使用post传递参数 ");
		errorMap.put("SIGNERROR","参数签名结果不正确");
		errorMap.put("XML_FORMAT_ERROR","XML格式错误");
		errorMap.put("FREQUENCY_LIMITED","2个月之前的订单申请退款有频率限制");
		
		//https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_5
		//查询退款错误码
		errorMap.put("SYSTEMERROR","系统超时");
		errorMap.put("REFUNDNOTEXIST","订单号错误或订单状态不正确");
		errorMap.put("INVALID_TRANSACTIONID","请求参数未按指引进行填写");
		errorMap.put("PARAM_ERROR","请求参数未按指引进行填写");
		errorMap.put("APPID_NOT_EXIST","参数中缺少APPID");
		errorMap.put("MCHID_NOT_EXIST","参数中缺少MCHID");
		errorMap.put("REQUIRE_POST_METHOD","未使用post传递参数 ");
		errorMap.put("SIGNERROR","参数签名结果不正确");
		errorMap.put("XML_FORMAT_ERROR","XML格式错误");
		errorMap.put("APPID_NOT_EXIST","参数中缺少APPID");
		errorMap.put("MCHID_NOT_EXIST","参数中缺少MCHID");
		errorMap.put("ORDERNOTEXIST","缺少有效的订单号");
		errorMap.put("REQUIRE_POST_METHOD","未使用post传递参数 ");
		errorMap.put("SIGNERROR","参数签名结果不正确");
		errorMap.put("XML_FORMAT_ERROR","XML格式错误");
		errorMap.put("FREQUENCY_LIMITED","2个月之前的订单申请退款有频率限制");

	}
	/**
	 * 根据微信错误码获取错误原因
	 * @param error
	 * @return
	 */
	public static String getErrorMsg(String error ) {
		return errorMap.get(error);
	}
}
