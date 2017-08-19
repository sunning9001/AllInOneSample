import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.example.grpc.hello.HelloServiceGrpc.HelloServiceFutureStub;
import com.example.grpc.hello.Helloworld.HelloReply;
import com.example.grpc.hello.Helloworld.HelloRequest;
import com.google.common.util.concurrent.ListenableFuture;
import com.linecorp.armeria.client.ClientBuilder;
import com.linecorp.armeria.client.ClientFactory;
import com.linecorp.armeria.client.ClientFactoryBuilder;
import com.linecorp.armeria.client.Clients;
import com.linecorp.armeria.client.logging.LoggingClient;
import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;
import com.spotify.futures.CompletableFuturesExtra;

public class GrpcClient {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		
		for (int i = 0; i < 1; i++) {
			long a = System.currentTimeMillis();
			try {
				System.out.println( Duration.ofSeconds(50).toMillis());
				
				
				
		    	ClientFactory factory=  new ClientFactoryBuilder().idleTimeout( Duration.ofSeconds(50)).build();
		
				ClientBuilder builder = new ClientBuilder("gproto+http://127.0.0.1:8080/")
						.decorator(HttpRequest.class, HttpResponse.class, LoggingClient.newDecorator()).defaultResponseTimeout( Duration.ofSeconds(20));
				
				HelloServiceFutureStub helloService = builder.build(HelloServiceFutureStub.class);																			// HelloServiceFutureStub.class
					
				HelloRequest request = HelloRequest.newBuilder().setName("Armerian World").build();
				ListenableFuture<HelloReply> reply = helloService.hello(request);
				reply.get();
				
				
				//CompletableFuture<HelloReply> completable = CompletableFuturesExtra.toCompletableFuture(reply);
				//HelloReply result = completable.get(20, TimeUnit.SECONDS);
			/*	System.out.println("11111111");
				System.out.println("时间" +((System.currentTimeMillis() -a ) /1000));*/
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("时间" +((System.currentTimeMillis() -a ) /1000));
			}
			
		}
	
		
	}
}
