import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.HelloService;

@SpringBootApplication(scanBasePackages="sample")
public class Application implements CommandLineRunner {
	@Autowired
	HelloService service;
     public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		System.out.println(service.sayHello());

	}

}
