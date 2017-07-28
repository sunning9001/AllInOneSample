package jmxutilssample;

import java.lang.management.ManagementFactory;

import org.weakref.jmx.MBeanExporter;
import org.weakref.jmx.Managed;

public class ManagedObject {

	private int value;

	@Managed
	public int getValue() {
		System.out.println("getValue:" + value);
		return this.value;
	}

	@Managed
	public void setValue(int value) {
		this.value = value;
		System.out.println("setValue:" + value);
	}

	@Managed(description = "do the operation")
	public void operation() {
		System.out.println("do something ......");
	}

	public static void main(String[] args) throws InterruptedException {

		MBeanExporter exporter = new MBeanExporter(ManagementFactory.getPlatformMBeanServer());
		exporter.export("test:name=X", new ManagedObject());

		// Wait forever
		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);
	}
}
