package HystrixSample;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        return "Hello " + name + "!";
    }
    
    public static void main(String[] args) {
    	String s = new CommandHelloWorld("Bob").execute();
    	//Future<String> s = new CommandHelloWorld("Bob").queue();
    	//Observable<String> s = new CommandHelloWorld("Bob").observe();
	}
}