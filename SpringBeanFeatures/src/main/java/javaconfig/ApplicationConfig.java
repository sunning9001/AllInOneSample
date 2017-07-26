package javaconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Starting with Spring 3.0, many features provided by the Spring JavaConfig project became part of the core Spring Framework.

//Thus you can define beans external to your application classes by using Java rather than XML files. 


//To use these new features, see the @Configuration, @Bean, @Import and @DependsOn annotations.

@Configuration

public class ApplicationConfig {
   @Bean
   public HelloService helloService(){
	   return new HelloServiceImpl();
   }
   
}
