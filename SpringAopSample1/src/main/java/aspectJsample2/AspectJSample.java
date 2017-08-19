package aspectJsample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJSample {

	public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aspectj.xml");
        LoginService loginService = (LoginService) applicationContext.getBean("loginService");
        loginService.login("sdf");
    }
}
