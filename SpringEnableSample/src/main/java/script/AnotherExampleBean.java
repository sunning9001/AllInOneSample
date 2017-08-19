package script;

import org.springframework.beans.factory.InitializingBean;

public class AnotherExampleBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("  *******AnotherExampleBean******afterPropertiesSet***********");

	}

}
