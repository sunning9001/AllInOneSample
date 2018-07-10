package com.sun.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户类型
 * @author zhuoyuqing
 *
 */
public class AccountType {

	private static final Map<String, String> accountMap =new HashMap<String, String>();
	
	public static final String  code01 ="1" ;  //财政专户
	public static final String  code02 ="2" ;  //汇缴专户
	public static final String  code03 ="3" ;  //科目
	public static final String  code04 ="4" ;  //单位代收账户
	public static final String  code05 ="5" ;  //单位账户
	public static final String  code06 ="9" ;  //其他
	
	static {
		accountMap.put(code01, "财政专户");
		accountMap.put(code02, "汇缴专户");
		accountMap.put(code03, "科目");
		accountMap.put(code04, "单位代收账户");
		accountMap.put(code05, "单位账户");
		accountMap.put(code06, "其他");
	}
	

	/**
	 * 获得账户类型描述
	 * @param code
	 * @return
	 */
	public static  String getCodeDesc(String code) {
		return accountMap.get(code);
	}
	
}
