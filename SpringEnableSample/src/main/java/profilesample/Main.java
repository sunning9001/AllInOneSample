package profilesample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// Sets the active profiles
		context.getEnvironment().setActiveProfiles("b");
		// Scans the mentioned package[s] and register all the @Component
		// available to Spring
		context.scan("profilesample");
		context.refresh();

		HelloWorld bean = context.getBean(HelloWorld.class);

		System.out.println(bean.getMsg());
	}
}
