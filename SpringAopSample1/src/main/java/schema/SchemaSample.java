package schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaSample {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:schema.xml");
		LoginService loginService = (LoginService) applicationContext.getBean("loginService");
		loginService.login("sdf");
	}
}
