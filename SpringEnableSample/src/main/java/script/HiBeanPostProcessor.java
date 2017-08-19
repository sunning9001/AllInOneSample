package script;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HiBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("***Hi*****postProcessBeforeInitialization********");
		System.out.println("******beanName*********:"+beanName);

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("****Hi****postProcessAfterInitialization********");
		System.out.println("******beanName*********:"+beanName);
		return bean;
	}

}
