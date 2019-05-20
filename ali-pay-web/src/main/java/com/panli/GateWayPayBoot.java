package com.panli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GateWayPayBoot extends SpringBootServletInitializer implements EnvironmentAware {
    
    private static final Logger logger = LoggerFactory.getLogger(SpringBootServletInitializer.class);
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(GateWayPayBoot.class).bannerMode(Banner.Mode.OFF);
    }

	@Override
	public void setEnvironment(Environment environment) {

	}


}