package rmi;

import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

public class ConnectorFactory {
	public static RemoteMBeanServer createConnector(String transport, Properties props) throws ConnectorException {
		if (transport.equalsIgnoreCase("RMI")) {
			try {
				return (RemoteMBeanServer) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
						new Class[] { RemoteMBeanServer.class }, new RMIInvocationHandler(props));
			} catch (Exception e) {
				throw new ConnectorException("Unable to create proxy.", e);
			}
		}
		throw new ConnectorException("Unrecognized connector transport: " + transport);
	}
	
}