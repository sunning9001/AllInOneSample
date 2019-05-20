package com.demo.locker;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dreamroute.locker.interceptor.OptimisticLocker;

@Configuration
public class OptimisticLockerConfig {
	@Bean
	public OptimisticLocker locker() {
		OptimisticLocker locker = new OptimisticLocker();
		// 不设置versionColumn，默认为version
		Properties props = new Properties();
		props.setProperty("versionColumn", "version");
		locker.setProperties(props);
		return locker;
	}
}
