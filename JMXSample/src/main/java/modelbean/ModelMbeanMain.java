package modelbean;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBean;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

public class ModelMbeanMain {
      public static void main(String[] args) throws Exception {
		
		MBeanServer mbs = MBeanServerFactory.createMBeanServer();
    	// The MBean Server

    	HashMap map = new HashMap();
    	// The resource that will be managed

    	// Construct the management interface for the Model MBean
    	Method getMethod = HashMap.class.getMethod("get", new Class[] {Object.class});
    	ModelMBeanOperationInfo getInfo =
    	    new ModelMBeanOperationInfo("Get value for key", getMethod);
    	ModelMBeanInfo mmbi =
    	    new ModelMBeanInfoSupport(HashMap.class.getName(),
    	                              "Map of keys and values",
    	                              null,  // no attributes
    	                              null,  // no constructors
    	                              new ModelMBeanOperationInfo[] {getInfo},
    	                              null); // no notifications

    	// Make the Model MBean and link it to the resource
    	ModelMBean mmb = new RequiredModelMBean(mmbi);
    	mmb.setManagedResource(map, "ObjectReference");

    	// Register the Model MBean in the MBean Server
    	ObjectName mapName = new ObjectName(":type=Map,name=whatever");
    	mbs.registerMBean(mmb, mapName);

    	// Resource can evolve independently of the MBean
    	map.put("key", "value");

    	// Can access the "get" method through the MBean Server
    	 mbs.invoke(mapName, "get", new Object[] {"key"}, new String[] {Object.class.getName()});
    	
    	

         // Wait forever
         System.out.println("Waiting...");
         Thread.sleep(Long.MAX_VALUE);
         

	}
}
