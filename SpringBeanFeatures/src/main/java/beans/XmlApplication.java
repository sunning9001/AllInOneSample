package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplication {
	public static void main(String[] args) {

		//The id attribute is a string that you use to identify the individual bean definition.
		//The class attribute defines the type of the bean and uses the fully qualified classname. 
		// The value of the id attribute refers to collaborating objects. 
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "services.xml" });
		
		BeanObject bean = context.getBean(BeanObject.class);
		
		System.out.println(bean);
	}
}
