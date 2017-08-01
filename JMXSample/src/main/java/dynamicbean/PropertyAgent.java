package dynamicbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class PropertyAgent {

	public static void main(String[] args) throws Exception {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("MyMBean:name=properties");
        PropertyManager propertiesMg = new PropertyManager("PropertyManager.properties");
        server.registerMBean(propertiesMg,helloName);

        ObjectName adapterName = new ObjectName("MyMBean:name=htmladapter");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter,adapterName);
        adapter.start();
        

        // Wait forever
        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE);
        
	}
}
