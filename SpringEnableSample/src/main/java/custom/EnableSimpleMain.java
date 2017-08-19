package custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EnableSimpleMain {
	public static void main(String[] args) {

		
		  ApplicationContext ctx = new AnnotationConfigApplicationContext("custom");
	      String s = ctx.getBean(String.class);
	      
	      System.out.println(s);
	}
}
