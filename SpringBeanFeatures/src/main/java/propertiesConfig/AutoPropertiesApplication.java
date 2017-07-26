package propertiesConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "propertiesConfig")
public class AutoPropertiesApplication {
	@Autowired
	static AutoProperties config;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("javaconfig");

		System.out.println(config.getBean());
	}

}
