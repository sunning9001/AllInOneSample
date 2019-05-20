package com.panli.wechat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.panli.wechat.util.IWXPayDomain;
import com.panli.wechat.util.WXPayConfig;

public class WXPayConfigImpl extends WXPayConfig {

	private String mchID;// 商户号
	private String key; // 密钥
	private String appID; // appID

	private String apiclientPath;// 证书路径
	private String notifyUrl;    //微信通知路径

	public void setMchID(String mchID) {
		this.mchID = mchID;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	@Override
	public String getAppID() {
		return this.appID;
	}

	@Override
	public String getMchID() {
		return this.mchID;
	}

	@Override
	public String getKey() {
		return this.key;
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
	public InputStream getCertStream() {
		InputStream is = null;
		try {
			is = new FileInputStream(new File(this.apiclientPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is ;
	}

	@Override
	public IWXPayDomain getWXPayDomain() {
		return new IWXPayDomain() {

			@Override
			public void report(String domain, long elapsedTimeMillis, Exception ex) {
				// TODO Auto-generated method stub

			}

			@Override
			public com.panli.wechat.util.IWXPayDomain.DomainInfo getDomain(WXPayConfig config) {
				// TODO Auto-generated method stub
				return new IWXPayDomain.DomainInfo("api.mch.weixin.qq.com", false);
			}
		};
	}

}
