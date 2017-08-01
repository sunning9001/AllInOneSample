package rmi;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.QueryExp;

public class MethodInvocation implements Serializable {
	static final long serialVersionUID = 7235369610255097138L;
	/* Status values. */
	public final static int OK = 1;
	public final static int ERROR = -99;
	/* MBean server reference. */
	private transient MBeanServer server = null;
	/* MethodInvocation 'payload'. */
	private String objectName = null;
	private String methodName = null;
	private Object[] params = null;
	private Object returnValue = null;
	private int status = OK;

	/* Constructors. */
	public MethodInvocation() {
	}

	public MethodInvocation(Method m) {
		setMethodName(m.getName());
	}

	/* Accessor methods. */
	public void setParams(Object[] params) {
		if (params == null || params.length < 1)
			return;
		this.params = params;
	}

	public void setMBeanServer(MBeanServer server) {
		this.server = server;
	}

	public Object getReturnValue() {
		return returnValue;
	}

	public int getStatus() {
		return status;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/* Invoke implementation. */
	public void invoke() {

		try {
			if (methodName.equals("createMBean")) {
				if (params.length == 2) {
					returnValue = server.createMBean((String) params[0], (ObjectName) params[1]);
				} else if (params.length == 3) {
					returnValue = server.createMBean((String) params[0], (ObjectName) params[1],
							(ObjectName) params[2]);
				} else if (params.length == 4) {
					returnValue = server.createMBean((String) params[0], (ObjectName) params[1], (Object[]) params[2],
							(String[]) params[3]);
				} else if (params.length == 5) {
					returnValue = server.createMBean((String) params[0], (ObjectName) params[1], (ObjectName) params[2],
							(Object[]) params[3], (String[]) params[4]);
				}
			} else if (methodName.equals("unregisterMBean")) {
				server.unregisterMBean((ObjectName) params[0]);
			} else if (methodName.equals("getObjectInstance")) {
				returnValue = server.getObjectInstance((ObjectName) params[0]);
			} else if (methodName.equals("isRegistered")) {
				returnValue = new Boolean(server.isRegistered((ObjectName) params[0]));
			} else if (methodName.equals("getMBeanCount")) {
				returnValue = server.getMBeanCount();
			} else if (methodName.equals("getAttribute")) {
				returnValue = server.getAttribute((ObjectName) params[0], (String) params[1]);
			} else if (methodName.equals("getAttributes")) {
				returnValue = server.getAttributes((ObjectName) params[0], (String[]) params[1]);
			} else if (methodName.equals("setAttribute")) {
				server.setAttribute((ObjectName) params[0], (Attribute) params[1]);
			} else if (methodName.equals("setAttributes")) {
				returnValue = server.setAttributes((ObjectName) params[0], (AttributeList) params[1]);
			} else if (methodName.equals("invoke")) {
				returnValue = server.invoke((ObjectName) params[0], (String) params[1], (Object[]) params[2],
						(String[]) params[3]);
			} else if (methodName.equals("getDefaultDomain")) {
				returnValue = server.getDefaultDomain();
			} else if (methodName.equals("addNotificationListener")) {
			} else if (methodName.equals("removeNotificationListener")) {
			} else if (methodName.equals("getMBeanInfo")) {
				returnValue = server.getMBeanInfo((ObjectName) params[0]);
			} else if (methodName.equals("isInstanceOf")) {
				returnValue = new Boolean(server.isInstanceOf((ObjectName) params[0], (String) params[1]));
			} else if (methodName.equals("queryNames")) {
				returnValue = server.queryNames((ObjectName) params[0], (QueryExp) params[1]);
			} else if (methodName.equals("queryMBeans")) {
				returnValue = server.queryMBeans((ObjectName) params[0], (QueryExp) params[1]);
			}
		} catch (Throwable t) {
			returnValue = t;
			status = ERROR;
		}

	}
}
