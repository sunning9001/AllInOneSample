package rmi;

import java.util.Iterator;
import java.util.Properties;

public class ConnectorClient implements RMIConnectorConstants {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(HOST, "localhost");
		props.put(PORT, "1099");
		try {
			RemoteMBeanServer server = ConnectorFactory.createConnector("RMI", props);
			Iterator it = server.queryNames(null, null).iterator();
			while (it.hasNext())
				System.out.println(it.next());
		} catch (ConnectorException e) {
			e.printStackTrace();
		}
	}
}