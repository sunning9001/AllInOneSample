package javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//ApplicationContext implementation is capable of accepting not only @Configuration classes as input, but also plain @Component classes and classes annotated with JSR-330 metadata


public class Application {
  public static void main(String[] args) {
	
	 AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext("javaconfig");
	 
	 HelloService service = (HelloService)context.getBean("helloService");
	 
	 System.out.println(service.sayHi());
}
}
