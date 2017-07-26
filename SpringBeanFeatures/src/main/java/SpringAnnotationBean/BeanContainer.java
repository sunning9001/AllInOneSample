package SpringAnnotationBean;

import org.springframework.beans.factory.annotation.Autowired;



public class BeanContainer {
	private BeanObject bean;

	@Autowired
	public void setBean(BeanObject bean) {
		this.bean = bean;
	}

	public BeanObject getBean() {
		return bean;
	}
	
	
}
