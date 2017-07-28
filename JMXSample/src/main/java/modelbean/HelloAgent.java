package modelbean;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.modelmbean.RequiredModelMBean;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {

	 public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
	        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

	        ObjectName helloName = new ObjectName("MyMBean:name=HelloWorld");
	        //Hello hello = new Hello();
	        RequiredModelMBean hello = ModelMBeanUtils.createModelerMBean();
	        server.registerMBean(hello, helloName);

	        ObjectName adapterName = new ObjectName("MyMBean:name=htmladapter,port=8082");
	        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
	        server.registerMBean(adapter, adapterName);
	        adapter.start();
	    }
}
