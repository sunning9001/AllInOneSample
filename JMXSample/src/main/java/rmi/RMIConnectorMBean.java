package rmi;

public interface RMIConnectorMBean {

	public void startServer(String agentID) throws java.rmi.RemoteException;

	public String getName();

	public void setName(String name);

	public int getPort();

	public void setPort(int port);
}