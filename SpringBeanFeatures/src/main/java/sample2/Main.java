package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "sample2.xml" });
		
		HelloWorld hw = context.getBean(HelloWorld.class);
		System.out.println(hw);
		hw =null;
		HelloWorld hw1 = (HelloWorld)context.getBean("hw");
		System.out.println(hw1.obj1.toString());
	}
}
