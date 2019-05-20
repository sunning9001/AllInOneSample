package com.panli.wechat.res;

import java.util.Map;

/**
 * 返回调用方法工具类
 * 
 * @author sunning
 *
 */
public class ResponseUtil {

	private final static String RETURN_CODE = "return_code";
	private final static String RETURN_MSG = "return_msg";
	
	public final static String DEFAULT_FAIL_CODE="FAIL";
	public  final static String DEFAULT_FAIL_MSG="未知错误";

	public static void allocateReturnRes(ReturnRes res, Map<String, String> resMap) {
		if (resMap != null && res != null) {
			res.setCode(resMap.get(RETURN_CODE));
			res.setMsg(resMap.get(RETURN_MSG));
		}
	}
}
