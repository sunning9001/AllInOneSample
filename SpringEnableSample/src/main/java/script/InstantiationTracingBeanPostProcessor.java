package script;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor  {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("********postProcessBeforeInitialization********");
		System.out.println("******beanName*********:"+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("********postProcessAfterInitialization********");
		System.out.println("******beanName*********:"+beanName);
		return bean;
	}

}
