import com.example.grpc.hello.HelloServiceGrpc.HelloServiceBlockingStub;
import com.example.grpc.hello.Helloworld.HelloReply;
import com.example.grpc.hello.Helloworld.HelloRequest;
import com.linecorp.armeria.client.Clients;

public class GrpcClient {
	public static void main(String[] args) {

		HelloServiceBlockingStub helloService = Clients.newClient(
		        "gproto+http://127.0.0.1:8080/",
		        HelloServiceBlockingStub.class); // or HelloServiceFutureStub.class or HelloServiceStub.class

		HelloRequest request = HelloRequest.newBuilder().setName("Armerian World").build();
		HelloReply reply = helloService.hello(request);
		
	    System.out.println(reply.getMessage());
	}
}
