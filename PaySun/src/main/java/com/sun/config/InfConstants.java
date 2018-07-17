package com.sun.config;
import java.util.HashMap;
import java.util.Map;

import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillfundResultsMessageRequest;

public class InfConstants {

	public static final String BillSync = "wp.bill.sync";// 票据同步接口
	public static final String OuterBillPayQuery = "wp.outer.bill.pay.query";// 票据查询接口
	public static final String OuterBillPay = "wp.outer.bill.pay";// 票据缴款接口
	public static final String OuterAccountBillFund = "wp.outer.account.billfund";// 资金对账请求接口
	public static final String AccountBillFundConfirm = "wp.account.billfund.confirm";// 资金对账结果接口
	public static final String OuterBillNew = "wp.outer.bill.new";// 输入票据接口
	public static final String OuterBillEduSync = "wp.bill.edu.sync";// 教育缴费同步接口

	

	/**
	 * 接口名称和响应对象映射关系 例如: 票据同步接口 映射 票据同步接口响应对象
	 */
	public static final Map<String, Class> infRequestClazzMap = new HashMap<String, Class>();
	static {

		/**
		 * 处理来废水系统的请求消息
		 */
		infRequestClazzMap.put(BillSync, BillSyncMessageRequest.class);
		
		infRequestClazzMap.put(AccountBillFundConfirm, BillfundResultsMessageRequest.class);

	}
	/**
	 * 根据接口   
	 * @param infName
	 * @return
	 */
	public static Class getInfRequestClazz(String infName) {
		return infRequestClazzMap.get(infName);
	}
}
