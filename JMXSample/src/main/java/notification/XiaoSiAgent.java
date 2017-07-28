package notification;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import jmxsample.Hello;

public class XiaoSiAgent {
	public static void main(String[] args) throws Exception {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();

		ObjectName helloName = new ObjectName("MyMBean:name=HelloWorld");
		Hello hello = new Hello();
		server.registerMBean(hello, helloName);

		ObjectName adapterName = new ObjectName("MyBean:name=htmladapter,port=8082");
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		server.registerMBean(adapter, adapterName);

		XiaoSi xs = new XiaoSi();
		server.registerMBean(xs, new ObjectName("MyMBean:name=xiaosi"));
		xs.addNotificationListener(new HelloListener(), null, hello);
		adapter.start();
	}
}
