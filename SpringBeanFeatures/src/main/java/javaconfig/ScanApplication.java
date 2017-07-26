package javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="javaconfig")
public class ScanApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.refresh();
		HelloService myService = ctx.getBean(HelloService.class);
		System.out.println(myService.sayHi());
	}
}
