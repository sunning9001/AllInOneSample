package webserver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerImpl implements GreetingController {
  
    @Override
    public String greeting(@PathVariable("username") String username) {
    	System.out.println("greeting==>" +username);
        return String.format("Hello %s!\n", username);
    }
}