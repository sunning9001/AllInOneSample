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

	private static final String sf_paid ="1";// 非税平台-已缴费
	
	
	private static final Map<String, String> sf2Pay =new HashMap<>();
	private static final Map<String, String> pay2sf =new HashMap<>();
	
	
	static {
		
		
		//注册对应关系
	}
	
	
	/**
	 *  根据非税系统状态映射到对应的支付平台状态
	 * @param fsStatus
	 * @return
	 */
	public String getPayPlatformStatus(String fsStatus) {
		return "支付平台状态";
	}
	
	public String getSFStatus(String payPlatformStatus) {
		 return "非税系统状态";
	}
}

