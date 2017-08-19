package springbootcondictionsample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbootcondictionsample.conditional.MyConditionalOnClass;

@Configuration
@MyConditionalOnClass(name ="springbootcondictionsample.PresentObject")
public class AutoConfig {

	@Bean
	public OnClassObject onClassObject(){
		return new OnClassObject();
	}
}
