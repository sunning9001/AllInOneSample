package conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		  ApplicationContext ctx = new AnnotationConfigApplicationContext("conditional");
		  
		  ctx.getBean(HelloWorld.class);
	}
	
}
