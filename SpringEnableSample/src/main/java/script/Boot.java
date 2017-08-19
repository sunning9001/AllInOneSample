package script;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Boot {
	 public static void main(final String[] args) throws Exception {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("script/beans.xml");
	         ctx.getBean(AnotherExampleBean.class);
	      
	    }

}
