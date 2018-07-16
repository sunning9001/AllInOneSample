package com.sun.util;

import java.util.HashMap;
import java.util.Map;

/**
 *   状态转换
 *   公共支付平台支付状态和非税系统支付状态相关转换类
 * @author sunning
 *
 */
public class StatusConvertUtil {

	private static final String sf_paid ="3";// 非税平台-已缴费
	private static final String sf_cancel ="2";// 非税平台-作废
	private static final String sf_print ="1";// 非税平台-已打印
	
	private static final String pay_nopaid ="0";// 支付平台-未缴费
	private static final String pay_paid ="1" ; //支付平台-已缴款
	private static final String pay_cancel = "2" ;//支付平台-已作废
	
	
	
	private static final Map<String, String> sf2Pay =new HashMap<String, String>();
	private static final Map<String, String> pay2sf =new HashMap<String, String>();
	
	
	static {
		//注册对应关系
		
		sf2Pay.put(sf_paid,pay_paid);
		sf2Pay.put(sf_cancel,pay_cancel);
		sf2Pay.put(sf_print, pay_nopaid);
		
		pay2sf.put(pay_nopaid, sf_print);
		pay2sf.put(pay_paid, sf_paid);
		pay2sf.put(pay_cancel, sf_cancel);
		
	}
	
	
	/**
	 *  根据非税系统状态映射到对应的支付平台状态
	 * @param fsStatus
	 * @return
	 */
	public static String getPayPlatformStatus(String fsStatus) {
		return sf2Pay.get(fsStatus);
	}
	
	public static String getSFStatus(String payPlatformStatus) {
		 return pay2sf.get(payPlatformStatus);
	}
	
	
}

