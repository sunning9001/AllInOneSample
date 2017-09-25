import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import com.example.grpc.hello.HelloServiceGrpc.HelloServiceFutureStub;
import com.example.grpc.hello.Helloworld.HelloReply;
import com.example.grpc.hello.Helloworld.HelloRequest;
import com.google.common.util.concurrent.ListenableFuture;
import com.linecorp.armeria.client.ClientBuilder;
import com.linecorp.armeria.client.ClientFactory;
import com.linecorp.armeria.client.ClientFactoryBuilder;
import com.linecorp.armeria.client.logging.LoggingClient;
import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;

public class GrpcClient {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		
		
    	ClientFactory factory=  new ClientFactoryBuilder().idleTimeout( Duration.ofSeconds(50)).build();

		ClientBuilder builder = new ClientBuilder("gproto+http://127.0.0.1:18080/")
				.decorator(HttpRequest.class, HttpResponse.class, LoggingClient.newDecorator()).defaultResponseTimeout( Duration.ofSeconds(20));
		
		HelloServiceFutureStub helloService = builder.build(HelloServiceFutureStub.class);																			// HelloServiceFutureStub.class
			
		HelloRequest request = HelloRequest.newBuilder().setName("Armerian World").build();
		ListenableFuture<HelloReply> reply = helloService.hello(request);

		System.out.println("============================");
		System.out.println("vvvvvvvvvvvvvvvvvvvvvv:"+reply.get().getMessage());
	
		
	}
}
