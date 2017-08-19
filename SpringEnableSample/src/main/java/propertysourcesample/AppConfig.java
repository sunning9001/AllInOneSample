package propertysourcesample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/propertysourcesample/app.properties")
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public HelloWorld helloWorld() {

		
		HelloWorld hw = new HelloWorld();
		hw.setMsg(env.getProperty("a"));
		return hw;
	}
}
