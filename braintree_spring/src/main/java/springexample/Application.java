package springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.braintreegateway.BraintreeGateway;

@SpringBootApplication
public class Application {
    public static String DEFAULT_CONFIG_FILENAME = "config.properties";
    public static BraintreeGateway gateway;

    public static void main(String[] args) 
    {
        try {
            gateway =BraintreeGatewayFactory.fromInputStream(Application.class.getResourceAsStream(DEFAULT_CONFIG_FILENAME));
        } catch (NullPointerException e) {
            System.err.println("Could not load Braintree configuration from config file or system environment.");
            System.exit(1);
        }
        SpringApplication.run(Application.class, args);
    }
}
