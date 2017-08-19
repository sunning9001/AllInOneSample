package springaopsample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class SpringAopAdvisorSample 
{
    public static void main( String[] args )
    {

    	 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:advisor.xml");
         LoginService loginService = (LoginService) applicationContext.getBean("loginProxy");
         loginService.login("sdf");
    }
}
