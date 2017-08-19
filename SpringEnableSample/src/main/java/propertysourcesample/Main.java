package propertysourcesample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("propertysourcesample");
		context.refresh();

		HelloWorld bean = context.getBean(HelloWorld.class);

		System.out.println(bean.getMsg());
	}
}
