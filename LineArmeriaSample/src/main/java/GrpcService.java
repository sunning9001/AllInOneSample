import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.grpc.GrpcServiceBuilder;
import static com.linecorp.armeria.common.SessionProtocol.HTTP;

import java.time.Duration;

public class GrpcService {
	public static void main(String[] args) {

		ServerBuilder sb = new ServerBuilder().idleTimeout( Duration.ofSeconds(50)).defaultRequestTimeout( Duration.ofSeconds(50));
		sb.port(18080, HTTP);
		sb.serviceUnder("/", new GrpcServiceBuilder().addService(new MyHelloService()).build());

		Server server = sb.build();
		server.start();
	}
}
