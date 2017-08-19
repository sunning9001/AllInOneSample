package sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "sample4.xml" });

		TestBean testBean = context.getBean(TestBean.class);
		
		System.out.println(testBean.bean);
	}
}
