package sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class RequiredSample {

	private RequiredClazz clazz;

	public RequiredClazz getClazz() {
		return clazz;
	}

	@Required
	@Autowired

	public void setClazz(RequiredClazz clazz) {
		this.clazz = clazz;
	}

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "required-beans.xml" });
		RequiredSample c = context.getBean(RequiredSample.class);
		
		System.out.println(c.getClazz().getS());
	
	}
}
