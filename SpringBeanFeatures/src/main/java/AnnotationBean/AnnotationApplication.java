package AnnotationBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "AnnotationBean")
public class AnnotationApplication {
	public static void main(String[] args) {

		// context:annotation-config/> only looks for annotations on beans in
		// the same application context in which it is defined.

		// This means that, if you put <context:annotation-config/> in a
		// WebApplicationContext for a DispatcherServlet, it only checks for
		// @Autowired beans in your controllers, and not your services.

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(BeanConfig.class);
		context.refresh();
		BeanObject bean = context.getBean(BeanObject.class);

		System.out.println(bean);

		BeanContainer container = context.getBean(BeanContainer.class);

		System.out.println(container.getBean());
	}
}
