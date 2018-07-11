package com.sun.config;

import java.util.HashMap;
import java.util.Map;

/**
 *  结果码
 * @author zhuoyuqing
 *
 */
public class ResultCode {

	private static final Map<String, String> resultMap =new HashMap<String, String>();
	
	public static final String code01="10000" ; // 接口调用成功
	public static final String code02="20000" ; // 服务不可用
	public static final String code03="30001" ; // 缺少必要参数
	public static final String code04="30002" ; // 非法参数
	public static final String code05="99999" ; // 系统内部错误
	
	static {
		resultMap.put(code01, "接口调用成功");
		resultMap.put(code02, "服务不可用");
		resultMap.put(code03, "缺少必要参数");
		resultMap.put(code04, "非法参数");
		resultMap.put(code05, "系统内部错误");
	}
	

	/**
	 * 获得账户类型描述
	 * @param code
	 * @return
	 */
	public static  String getCodeDesc(String code) {
		return resultMap.get(code);
	}
}
