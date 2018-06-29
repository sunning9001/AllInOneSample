package com.sun.msg;

import com.alibaba.fastjson.JSONObject;
import com.sun.msg.request.BillSyncRequest;

/**
 * 请求消息
 * 
 * @author sunning
 *
 */
public class BillSyncMessageRequest {

	/**
	 * 公共参数
	 */
	private String zone_code;// 行政区域
	private String method;// 方法名称,见InfConstants接口
	private String timestamp;// 发送请求时间,格式yyyyMMddmmss 如：20180626231122
	private String version = "1.0"; // 接口版本号,固定值
	/**
	 * 请求参数
	 */
	private BillSyncRequest biz_content; // 请求对象

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Object getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(BillSyncRequest biz_content) {
		this.biz_content = biz_content;
	}

	@Override
	public String toString() {
		return "BillSyncMessageRequest [zone_code=" + zone_code + ", method=" + method + ", timestamp=" + timestamp
				+ ", version=" + version + ", biz_content=" + biz_content + "]";
	}
    public static void main(String[] args) {
		BillSyncMessageRequest  msg =new BillSyncMessageRequest();
		msg.setZone_code("zonecode");
		msg.setMethod("wp.bill.sync");
		msg.setTimestamp("20180629010111");
		msg.setVersion("1.0");
		
		BillSyncRequest r= new BillSyncRequest();
		r.setChg_code("chg_code");
		msg.setBiz_content(r);
		

		 System.out.println( JSONObject.toJSONString(msg));
	}

}
