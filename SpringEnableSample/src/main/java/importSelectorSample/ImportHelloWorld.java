package importSelectorSample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportHelloWorld {

	public ImportHelloWorld() {
		System.out.println("=========");
	}
	@Bean
	public ImportHelloWorld helloworld(){
		return new ImportHelloWorld();
	}
}
