package autoproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aop-auto-proxy.xml");
		LoginService loginService = (LoginService) applicationContext.getBean("loginService");
		loginService.login("sdf");
	}
}
