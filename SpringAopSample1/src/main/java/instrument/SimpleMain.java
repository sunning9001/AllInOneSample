package instrument;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMain {
  public static void main(String[] args) {
	
	  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:instrument.xml");
      LoginServiceImpl loginService = (LoginServiceImpl) applicationContext.getBean("loginProxy");
      loginService.login("sdf");

      SendEmailService sendEmailService = (SendEmailService) loginService;
      sendEmailService.sendEmail();
}
}
