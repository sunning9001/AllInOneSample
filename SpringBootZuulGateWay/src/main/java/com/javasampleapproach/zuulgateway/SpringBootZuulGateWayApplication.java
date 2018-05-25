package com.javasampleapproach.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
//http://javasampleapproach.com/spring-framework/spring-cloud/configure-springboot-zuul-routing-filtering
public class SpringBootZuulGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZuulGateWayApplication.class, args);
	}
}
