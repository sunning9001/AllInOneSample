import java.util.concurrent.CompletableFuture;

import com.example.grpc.hello.HelloServiceGrpc.HelloServiceFutureStub;
import com.example.grpc.hello.Helloworld.HelloReply;
import com.example.grpc.hello.Helloworld.HelloRequest;
import com.google.common.util.concurrent.ListenableFuture;
import com.linecorp.armeria.client.Clients;
import com.spotify.futures.CompletableFuturesExtra;

public class GrpcFutureClient {
	public static void main(String[] args) {

		HelloServiceFutureStub helloService = Clients.newClient(
		        "gproto+http://127.0.0.1:8080/",
		        HelloServiceFutureStub.class);

		HelloRequest request = HelloRequest.newBuilder().setName("Armerian World").build();
		ListenableFuture<HelloReply> future = helloService.hello(request);
		
		CompletableFuture<HelloReply> completable = CompletableFuturesExtra.toCompletableFuture(future);

	}
}
