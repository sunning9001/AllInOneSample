package com.panli.alipay.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {
	@Bean
	public JedisPool jedisPool() {
		JedisPool pool = new JedisPool( "101.132.131.185",6379);
		return pool;
	}
}
