package AnnotationBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public BeanContainer beanContainer(){
		return new BeanContainer();
	}
	
	@Bean
	public BeanObject beanObject(){
		return new BeanObject();
	}
	
}
