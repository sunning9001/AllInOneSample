import com.example.grpc.hello.HelloServiceGrpc.HelloServiceImplBase;
import com.example.grpc.hello.Helloworld.HelloReply;
import com.example.grpc.hello.Helloworld.HelloRequest;

import io.grpc.stub.StreamObserver;

public class MyHelloService  extends HelloServiceImplBase {
	@Override
	public void hello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
		HelloReply reply = HelloReply.newBuilder().setMessage("Hello, " + req.getName() + '!').build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}
