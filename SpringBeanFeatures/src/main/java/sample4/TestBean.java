package sample4;

import javax.inject.Inject;
import javax.inject.Named;

@Named("testBean")
public class TestBean {
	@Inject
    public InjectBean bean;
    
}
 