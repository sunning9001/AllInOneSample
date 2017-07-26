package AnnotationBean;

import javax.inject.Inject;



public class BeanContainer {
	private BeanObject bean;

	@Inject
	public void setBean(BeanObject bean) {
		this.bean = bean;
	}

	public BeanObject getBean() {
		return bean;
	}
	
	
}
