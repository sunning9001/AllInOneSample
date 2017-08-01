package rmi;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

public class RMIAgent {
	final static String SERVER_DELEGATE = "JMImplementation:type=MBeanServerDelegate";
	final static String AGENT_ID = "MBeanServerId";

	public static void main(String[] args) {
		MBeanServer server = MBeanServerFactory.createMBeanServer();
		try {
			String agentID = (String) server.getAttribute(new ObjectName(SERVER_DELEGATE), AGENT_ID);
			server.createMBean("rmi.RMIConnector", new ObjectName("Connector:transport=RMI"));
			server.invoke(new ObjectName("Connector:transport=RMI"), "startServer", new Object[] { agentID },
					new String[] { String.class.getName() });
		} catch (JMException e) {
			e.printStackTrace();
		}
	}
}
