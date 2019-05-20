package com.panli.wechat;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wxpay")
public class WechatConfigurationProperties {

	private String mchID;// 商户号
	private String key; // 密钥
	private String appID; // appID
	private String apiclientPath; // 证书路径
	private String notifyUrl; // 微信回调地址

	public String getMchID() {
		return mchID;
	}

	public void setMchID(String mchID) {
		this.mchID = mchID;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getApiclientPath() {
		return apiclientPath;
	}

	public void setApiclientPath(String apiclientPath) {
		this.apiclientPath = apiclientPath;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	@Override
	public String toString() {
		return "WechatConfigurationProperties [mchID=" + mchID + ", key=" + key + ", appID=" + appID
				+ ", apiclientPath=" + apiclientPath + ", notifyUrl=" + notifyUrl + "]";
	}

}
