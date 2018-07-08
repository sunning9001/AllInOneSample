package com.sun.config;
/**
 *  业务返回码
 */

import java.util.HashMap;
import java.util.Map;

public class ResponseCode {
  
	private static final Map<String, String> codeMap =new HashMap<String, String>();

	public static final String Success ="00000";//通用成功或者收妥应答
	public static final String fail ="99999";   //通用失败应答
	
	
	
	static {
		codeMap.put(Success, "通用成功或者收妥应答");
		codeMap.put(fail, "通用失败应答");
	}
	
	/**
	 * 获得业务返回码描述
	 * @param code
	 * @return
	 */
	public static  String getCodeDesc(String code) {
		return codeMap.get(code);
	}
}
