package rmi;

import java.rmi.RemoteException;

import javax.management.MBeanServer;



public class RMIServerInvoker implements MBeanServerInvoker {
	private transient MBeanServer server = null;

	public RMIServerInvoker(MBeanServer server) {
		this.server = server;
	}

	/* MBeanServerInvoker implementation. */
	public Object invoke(MethodInvocation mi) throws Exception {
		mi.setMBeanServer(server);
		mi.invoke();
		/* Handle exceptions and errors. */
		if (mi.getStatus() == MethodInvocation.ERROR) {
			Object val = mi.getReturnValue();
			if (val instanceof Exception)
				throw (Exception) val;
			else
				throw new RemoteException("Runtime exception or error at the server.", (Throwable) val);
		}
		/* Return the result of the invocation. */
		return mi.getReturnValue();
	}


}