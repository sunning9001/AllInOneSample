package com.sun.config;
/**
 *  业务返回码
 */

import java.util.HashMap;
import java.util.Map;

public class ResponseCode {
  
	private static final Map<String, String> codeMap =new HashMap<String, String>();

	public static final String Success ="00000";//通用成功或者收妥应答
	public static final String Success_default_msg ="业务处理成功";//业务处理成功
	public static final String fail ="99999";   //通用失败应答
	public static final String fail_default_msg ="业务尚未处理";
	
	public static final String argsMistake = "10002" ; // 参数错误不符合报文规范
	public static final String versionMistake = "10003" ; // 版本号错误或不支持本版本号
	
	public static final String transaction01 = "11001" ; //不存在的缴款码/非税缴款书编号查询
	public static final String transaction02 = "11002" ; //缴款码/非税缴款书校验码验证是失败
	public static final String transaction03 = "11003" ; //缴款书超期限
	public static final String transaction04 = "11004" ; //缴款书已作废
	public static final String transaction05 = "11005" ; //区划【xxxxx】在银行【xx】当前没有有效的财政账号
	public static final String transaction06 = "11006" ; //该缴款书此银行无法查询
	public static final String transaction07 = "12001" ; //重复缴款确认
	public static final String transaction08 = "12002" ; //缴款确认码与财政不一致
	public static final String transaction09 = "12003" ; //收款账户与财政不一致
	public static final String transaction10 = "12004" ; //收款金额与财政不一致
	public static final String transaction11 = "12005" ; //未被查询的缴款书做缴款确认
	public static final String transaction12 = "12006" ; //缴款日期不在被查询日期范围内的缴款确认
	public static final String transaction13 = "13001" ; //该流水号的未匹配资金到账已存在，但是内容不一致
	public static final String transaction14 = "13002" ; //单位汇缴户在有效期内不存在
	public static final String transaction15 = "14001" ; //该流水号在途资金到账已存在，但是内容不一致
	public static final String transaction16 = "14002" ; //在途资金到账金额与缴款书合计金额不符
	
	public static final String confirm01 = "15001" ; //财政端记录信息和对账信息中明细金额不一致
	public static final String confirm02 = "15002" ; //日间交易已传送但日终对账单中缺失
	public static final String confirm03 = "15003" ; //日间交易未传送但日终对账单中存在
	
	
	public static final String ticket01 = "16001" ; //指定的执收单位没有该类票据的开票权限
	public static final String ticket02 = "16002" ; //指定的执收单位没有票据的存在
	public static final String ticket03 = "16003" ; //执收单位没有该指定收费项目的收费权限
	public static final String ticket04 = "16004" ; //指定的收款银行信息有误
	public static final String ticket05 = "16005" ; //指定的收费项目明细中的金额合计与总金额不符
	
	
	
	
	
	
	
	static {
		codeMap.put(Success, "通用成功或者收妥应答");
		codeMap.put(fail, "通用失败应答");
		codeMap.put(argsMistake, "参数错误不符合报文规范");
		codeMap.put(versionMistake, "版本号错误或不支持本版本号");
		
		codeMap.put(transaction01, "不存在的缴款码/非税缴款书编号查询");
		codeMap.put(transaction02, "缴款码/非税缴款书校验码验证是失败");
		codeMap.put(transaction03, "缴款书超期限");
		codeMap.put(transaction04, "缴款书已作废");
		codeMap.put(transaction05, "区划【xxxxx】在银行【xx】当前没有有效的财政账号");
		codeMap.put(transaction06, "该缴款书此银行无法查询");
		codeMap.put(transaction07, "重复缴款确认");
		codeMap.put(transaction08, "缴款确认码与财政不一致");
		codeMap.put(transaction09, "收款账户与财政不一致");
		codeMap.put(transaction10, "收款金额与财政不一致");
		codeMap.put(transaction11, "未被查询的缴款书做缴款确认");
		codeMap.put(transaction12, "缴款日期不在被查询日期范围内的缴款确认");
		codeMap.put(transaction13, "该流水号的未匹配资金到账已存在，但是内容不一致");
		codeMap.put(transaction14, "单位汇缴户在有效期内不存在");
		codeMap.put(transaction15, "该流水号在途资金到账已存在，但是内容不一致");
		codeMap.put(transaction16, "在途资金到账金额与缴款书合计金额不符");
		
		
		codeMap.put(confirm01, "财政端记录信息和对账信息中明细金额不一致");
		codeMap.put(confirm02, "日间交易已传送但日终对账单中缺失");
		codeMap.put(confirm03, "日间交易未传送但日终对账单中存在");
		
		codeMap.put(ticket01, "指定的执收单位没有该类票据的开票权限");
		codeMap.put(ticket02, "指定的执收单位没有票据的存在");
		codeMap.put(ticket03, "执收单位没有该指定收费项目的收费权限");
		codeMap.put(ticket04, "指定的收款银行信息有误");
		codeMap.put(ticket05, "指定的收费项目明细中的金额合计与总金额不符");
		
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
