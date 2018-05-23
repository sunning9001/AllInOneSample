package sample;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

public class EurekaClientSample {

	    @RequestMapping("/")
	    public String home() {
	        return "Hello world";
	    }

	    public static void main(String[] args) {
	        new SpringApplicationBuilder(EurekaClientSample.class).web(true).run(args);
	    }
}
