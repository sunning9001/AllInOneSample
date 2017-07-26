package SpringAnnotationBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationApplication {
	public static void main(String[] args) {

	

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "anno-services.xml" });

		
		BeanObject bean = context.getBean(BeanObject.class);

		System.out.println(bean);

		BeanContainer container = context.getBean(BeanContainer.class);

		System.out.println(container.getBean());
	}
}
