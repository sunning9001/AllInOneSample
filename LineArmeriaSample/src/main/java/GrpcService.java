import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.grpc.GrpcServiceBuilder;
import static com.linecorp.armeria.common.SessionProtocol.HTTP;

public class GrpcService {
	public static void main(String[] args) {

		ServerBuilder sb = new ServerBuilder();
		sb.port(8080, HTTP);
		sb.serviceUnder("/", new GrpcServiceBuilder().addService(new MyHelloService()).build());

		Server server = sb.build();
		server.start();
	}
}
