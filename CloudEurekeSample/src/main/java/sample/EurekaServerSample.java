package sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSample {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServerSample.class).web(true).run(args);
	}
}
