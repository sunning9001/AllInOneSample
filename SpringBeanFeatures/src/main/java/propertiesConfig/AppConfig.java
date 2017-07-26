package propertiesConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:app.properties")
public class AppConfig {

	@Autowired
	Environment env;

	@Bean
	public AutoProperties autoProperties() {
		AutoProperties properties = new AutoProperties();
		properties.setBean(env.getProperty("testbean.name"));
		return properties;
	}
}
