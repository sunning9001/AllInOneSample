package sample;
//In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	  private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();
        //The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
	    //The above example does not specify GET vs. PUT, POST, and so forth, because @RequestMapping maps all HTTP operations by default. 
	    //@RequestMapping maps all HTTP operations by default.
	    @RequestMapping(path ={"/greeting"},method =RequestMethod.GET)
	    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	        return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
	    //Thanks to Spring’s HTTP message converter support, you don’t need to do this conversion manually. 
	    //Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Greeting instance to JSON.
}

	    
	    