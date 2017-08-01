package JolokiaSample;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.jolokia.jvmagent.JolokiaServer;
import org.jolokia.jvmagent.JolokiaServerConfig;
import org.jolokia.jvmagent.JvmAgent;
import org.jolokia.jvmagent.JvmAgentConfig;





public class JolokiaServerSample {
	public static void main(String[] args) throws Exception {

		
        // Get the Platform MBean Server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construct the ObjectName for the MBean we will register
        ObjectName name = new ObjectName("JolokiaSample:type=Hello");

        // Create the Hello World MBean
        Hello mbean = new Hello();
        mbean.setName("sunning");

        // Register the Hello World MBean
        mbs.registerMBean(mbean, name);
        
        
        
		Map<String, String> map =new HashMap<>();
		map.put("port", "8080");
		map.put("address", "localhost");
		JolokiaServerConfig pConfig=new JolokiaServerConfig(map);
		JolokiaServer server =new JolokiaServer(pConfig);
		
        
		
		server.start();
		//https://my.oschina.net/u/145002/blog/31965
		//http://hpeng526.github.io  mbean 采集系 统
        // Wait forever
        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
	}
}
