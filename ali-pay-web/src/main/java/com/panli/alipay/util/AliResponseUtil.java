package com.panli.alipay.util;

import com.alipay.api.AlipayResponse;
import com.panli.alipay.res.AliReturnRes;

public class AliResponseUtil {

	public final static String DEFAULT_FAIL_CODE = "FAIL";
	public final static String DEFAULT_FAIL_MSG = "未知错误";

	
	public static void allocateReturnRes(AlipayResponse response, AliReturnRes res) {
		if (response != null && res != null) {
			res.setCode(response.getCode());
			res.setMsg(res.getMsg());
		}
	}

}
