package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

public class RMIConnector implements RMIConnectorMBean {
	private String name = "jmx/RMIConnector";
	private int port = 6688; // anonymous port
	private MBeanServer server = null;

	public RMIConnector() {
	}

	public void startServer(String agentID) throws RemoteException {
		// find the mbean server reference
		server = (MBeanServer) MBeanServerFactory.findMBeanServer(agentID).get(0);
		MBeanServerInvoker invoker = new RMIServerInvoker(server);
		UnicastRemoteObject.exportObject(invoker, port);
		try {
			Naming.rebind(name, invoker);
		} catch (MalformedURLException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public MBeanServer getServer() {
		return server;
	}

	public void setServer(MBeanServer server) {
		this.server = server;
	}


}