package rmi;



public interface MBeanServerInvoker extends java.rmi.Remote {
	Object invoke(MethodInvocation mi) throws Exception, java.rmi.RemoteException;
}