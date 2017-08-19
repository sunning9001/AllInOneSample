import com.example.grpc.hello.HelloServiceGrpc.HelloServiceImplBase;
import com.example.grpc.hello.Helloworld.HelloReply;
import com.example.grpc.hello.Helloworld.HelloRequest;
import com.linecorp.armeria.common.RequestContext;
import com.linecorp.armeria.server.ServiceRequestContext;

import io.grpc.stub.StreamObserver;

public class MyHelloService  extends HelloServiceImplBase {
	@Override
	public void hello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
		
		ServiceRequestContext ctx = (ServiceRequestContext) RequestContext.current();
		ctx.blockingTaskExecutor().submit(() -> {
			
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("##########方法调用开始#########");
			HelloReply reply = HelloReply.newBuilder().setMessage("Hello, " + req.getName() + '!').build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
			System.out.println(" *******打印日志测试************");
		});
		
	}
}
