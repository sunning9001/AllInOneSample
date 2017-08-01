package rmi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;



public class RMIInvocationHandler implements InvocationHandler, RMIConnectorConstants {
	/* Remote reference to the connector server. */
	private MBeanServerInvoker invoker = null;
	/* Property values. */
	private String host = null;
	private String name = null;
	private int port = 1099;

	/* Constructor */
	public RMIInvocationHandler(Properties props) throws NotBoundException, MalformedURLException, RemoteException {
		/* Retrieve properties for remote connection. */
		host = props.getProperty(HOST, "localhost");
		port = Integer.parseInt(props.getProperty(PORT, "1099"));
		name = props.getProperty(REMOTE_NAME, "jmx/RMIConnector");
		/* Retrieve the stub implementing MBeanServerInvoker */
		String lookup = "//" + host + ":" + port + "/" + name;
		System.out.println("lookup:"+lookup);
		invoker = (MBeanServerInvoker) Naming.lookup(lookup);
	}

	/* InvocationHandler implementation */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/* Create and initialize serializable MI object. */
		MethodInvocation mi = new MethodInvocation(method);
		mi.setParams(args);
		/* Remote call to the connector server. */
		return invoker.invoke(mi);
	}
}
