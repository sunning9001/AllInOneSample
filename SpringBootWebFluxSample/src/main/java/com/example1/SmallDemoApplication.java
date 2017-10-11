package com.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example1" })
public class SmallDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallDemoApplication.class, args);
	}
}
