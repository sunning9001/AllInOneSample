package javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegisterJavaConfig {
	public static void main(String[] args) {

		//An AnnotationConfigApplicationContext may be instantiated using a no-arg constructor and then configured using the register() method.
		   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		    ctx.register(ApplicationConfig.class);
		    ctx.refresh();
		    HelloService myService = ctx.getBean(HelloService.class);
		   System.out.println(myService.sayHi());
	}
}
