package propertySource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:propertySource/appconfig.properties")
public class AutoAppConfig {

	@Autowired
	Environment env;
	
	@Bean
	public AppConfig appConfig(){
		AppConfig config =new AppConfig();
		System.out.println("==");
		config.setUrl(env.getProperty("url"));
		
		return config;
	}
}
