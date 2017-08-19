package sample2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("hw")
@Scope("prototype")
public class HelloWorld {

	private String hw ="hi ,Java Developer!";

	
	@Qualifier("BObj")
	public Obj  obj;
	
	

	@Autowired
	@Resource(name="AObj")
	public Obj  obj1;
	
	public String getHw() {
		return hw;
	}

	public void setHw(String hw) {
		this.hw = hw;
	}

	@Override
	public String toString() {
		return "HelloWorld [hw=" + hw + "]";
	}
	@PostConstruct
	public void init(){
		System.out.println("  @PostConstruct ");
	}
	@PreDestroy
	public void destory(){
		System.out.println("  @destory ");
	}
	
}
