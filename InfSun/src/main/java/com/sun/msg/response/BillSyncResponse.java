package com.sun.msg.response;

/**
 * 票据同步返回参数
 * 
 * @author sunning
 *
 */
public class BillSyncResponse {
	private String trade_id;// 标识公共支付平台处理的流水号

	public String getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}

	@Override
	public String toString() {
		return "BillSyncResponse [trade_id=" + trade_id + "]";
	}

}
