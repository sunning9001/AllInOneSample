package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//The service will handle GET requests for /greeting, optionally with a name parameter in the query string. 
//The GET request should return a 200 OK response with JSON in the body that represents a greeting. 
//http://localhost:8080/greeting?name=User

//In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller. 
//These components are easily identified by the @RestController annotation
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}