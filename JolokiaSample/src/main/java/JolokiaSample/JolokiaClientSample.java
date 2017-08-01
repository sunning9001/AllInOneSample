package JolokiaSample;

import org.jolokia.client.J4pClient;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;

public class JolokiaClientSample {
	public static void main(String[] args) throws Exception {

		J4pClient client = new J4pClient("http://localhost:8080/jolokia");
		J4pReadRequest request = new J4pReadRequest("JolokiaSample:type=Hello", "Name");

		J4pReadResponse response = client.execute(request);
		System.out.println("######Name:###### " + response.getValue());
	}
}
