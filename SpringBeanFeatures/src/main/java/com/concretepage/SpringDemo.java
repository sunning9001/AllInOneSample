package com.concretepage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class SpringDemo {
   public static void main(String[] args) {
	   
	   //http://www.concretepage.com/spring/spring-named-and-inject-jsr-330-annotation-example
	   
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
       ctx.register(AppConfig.class);
       ctx.refresh();
       EmployeeService service = ctx.getBean(EmployeeService.class);
       System.out.println(service.getEmployee().getEmpMsg());
       ctx.close();
   }
}
