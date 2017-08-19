package conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(MyCondiction.class)
public class HelloWorld {

	
	@Bean
	public HelloWorld helloWorld(){
		return new HelloWorld();
	}
}
