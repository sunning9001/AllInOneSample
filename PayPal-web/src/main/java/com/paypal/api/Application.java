package com.paypal.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages="com.paypal.api")
public class Application    {
    
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
	    
	    SpringApplication application = new SpringApplication(Application.class);

        application.run(args);
        

	}

}
