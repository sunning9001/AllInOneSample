package com.sun.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 收款渠道
 * @author zhuoyuqing
 *
 */
public class CollectChannel {

	private static final Map<String, String> channelMap =new HashMap<String, String>();
	
	public static final String  code01 ="1" ;  //查缴模式
	public static final String  code02 ="11" ; //柜台缴款
	public static final String  code03 ="12" ; //自助终端
	public static final String  code04 ="13" ; //网上缴款
	public static final String  code05 ="2" ; //推送模式
	public static final String  code06 ="21" ; //pos刷卡
	public static final String  code07 ="22" ; //网上支付
	public static final String  code08 ="3" ; //划缴模式
	public static final String  code09 ="4" ; //虚拟账号模式
	public static final String  code10 ="5" ; //第三方支付
	public static final String  code11 ="51" ; //支付宝
	public static final String  code12 ="52" ; //微信支付
	public static final String  code13 ="9" ; //其他
	
	static {
		channelMap.put(code01, "查缴模式");
		channelMap.put(code02, "柜台缴款");
		channelMap.put(code03, "自助终端");
		channelMap.put(code04, "网上缴款");
		channelMap.put(code05, "推送模式");
		channelMap.put(code06, "pos刷卡");
		channelMap.put(code07, "网上支付");
		channelMap.put(code08, "划缴模式");
		channelMap.put(code09, "虚拟账号模式");
		channelMap.put(code10, "第三方支付");
		channelMap.put(code11, "支付宝");
		channelMap.put(code12, "微信支付");
		channelMap.put(code13, "其他");
	}
	
	
	/**
	 * 获得收款渠道描述
	 * @param code
	 * @return
	 */
	public static  String getCodeDesc(String code) {
		return channelMap.get(code);
	}
	
}
