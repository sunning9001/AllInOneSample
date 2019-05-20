package com.panli.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.panli.wechat.util.WXPay;

@Configuration
public class WechatConfig {

	private final static Logger logger = LoggerFactory.getLogger(WechatConfig.class);
	
	@Autowired
	private WechatConfigurationProperties properties;

	
	@Bean 
	public WXPayConfigImpl wXPayConfigImpl() {
		WXPayConfigImpl config = new WXPayConfigImpl();
		config.setAppID(properties.getAppID());
		config.setMchID(properties.getMchID());
		config.setKey(properties.getKey());
		config.setApiclientPath(properties.getApiclientPath());
		config.setNotifyUrl(properties.getNotifyUrl());
		return config;
	}
	@Bean
	public WXPay wxPay() {
		try {
			return new WXPay( wXPayConfigImpl(), false);
		} catch (Exception e) {
			logger.debug("WechatConfig exception { }", e);
		}
		return null;
	}
}
