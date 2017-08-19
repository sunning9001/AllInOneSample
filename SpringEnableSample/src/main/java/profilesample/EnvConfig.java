package profilesample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EnvConfig {
	@Bean
	@MyProfile("a")
	public HelloWorld dvHelloWorld() {

		HelloWorld hw = new HelloWorld();
		hw.setMsg("development  hw");
		return hw;
	}
	@Bean
	@MyProfile("b")
	public HelloWorld proHelloWorld(){
		
		HelloWorld hw =new HelloWorld();
		hw.setMsg("production  hw");
		return hw;
	}
}
