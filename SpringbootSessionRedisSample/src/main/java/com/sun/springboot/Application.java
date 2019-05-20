package com.sun.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//https://blog.csdn.net/dream_broken/article/details/72676679
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	 @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }  

	 
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(Application.class, args);
	    }

	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
	//	configurableEmbeddedServletContainer.setPort(9090);
	}
}
