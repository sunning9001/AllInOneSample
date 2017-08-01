package modelbean;

import javax.management.Descriptor;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.modelmbean.DescriptorSupport;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class ModelExample {
	final static boolean READABLE = true;
	final static boolean WRITABLE = true;
	final static boolean BOOLEAN = true;

	public static void main(String[] args) {
		MBeanServer server = MBeanServerFactory.createMBeanServer();
		// build 'RoomName' read-write attribute
		Descriptor descr1 = new DescriptorSupport();
		descr1.setField("name", "Room");
		descr1.setField("descriptorType", "attribute");
		descr1.setField("displayName", "Room Number");
		descr1.setField("default", "D325");
		ModelMBeanAttributeInfo roomNameInfo = new ModelMBeanAttributeInfo("Room", // attribute
																					// name
				String.class.getName(), // attribute type
				"Room name or number.", // description
				READABLE, WRITABLE, !BOOLEAN, // read write
				descr1 // descriptor
		);
		// build 'Active' read-only attribute
		Descriptor descr2 = new DescriptorSupport();
		descr2.setField("name", "Active");
		descr2.setField("descriptorType", "attribute");
		descr2.setField("getMethod", "isActive");
		descr2.setField("currencyTimeLimit", "10");
		ModelMBeanAttributeInfo activeInfo = new ModelMBeanAttributeInfo("Active", boolean.class.getName(),
				"Printer state.", READABLE, !WRITABLE, !BOOLEAN, descr2);
		// build 'isActive' getter operation
		Descriptor descr3 = new DescriptorSupport();
		descr3.setField("name", "isActive");
		descr3.setField("descriptorType", "operation");
		descr3.setField("role", "getter");
		ModelMBeanOperationInfo isActiveInfo = new ModelMBeanOperationInfo("isActive", // name
																						// &
																						// description
				"Checks if the printer is currently active.", null, // signature
				boolean.class.getName(), // return type
				MBeanOperationInfo.INFO, // impact
				descr3 // descriptor
		);
		// MBean descriptor
		Descriptor descr4 = new DescriptorSupport();
		descr4.setField("name", "Printer");
		descr4.setField("descriptorType", "mbean");
		// create ModelMBeanInfo
		ModelMBeanInfo info = new ModelMBeanInfoSupport(RequiredModelMBean.class.getName(), // class
																							// name
				"Printer", // description
				new ModelMBeanAttributeInfo[] { // attributes
						roomNameInfo, activeInfo },
				null, // constructors
				new ModelMBeanOperationInfo[] { // operations
						isActiveInfo },
				null, // notifications
				descr4 // descriptor
		);
		try {
			// create and configure model mbean
			RequiredModelMBean model = new RequiredModelMBean();
			model.setManagedResource(new Printer(), "ObjectReference");
			model.setModelMBeanInfo(info);
			server.registerMBean(model, new ObjectName("example:name=model"));
		
			

			
			ObjectName adapterName = new ObjectName("XXOO" + ":name = htmladapter,port=8082");
			HtmlAdaptorServer adapter = new HtmlAdaptorServer();
			server.registerMBean(adapter, adapterName);
			adapter.start();
			
			
			// Wait forever
			System.out.println("Waiting...");
			Thread.sleep(Long.MAX_VALUE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
