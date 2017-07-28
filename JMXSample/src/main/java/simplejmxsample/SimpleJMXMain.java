package simplejmxsample;

import javax.management.JMException;

import com.j256.simplejmx.server.JmxServer;
import com.j256.simplejmx.web.JmxWebServer;

public class SimpleJMXMain {
	public static void main(String[] args) throws Exception {

		// create a new JMX server listening on a specific port
		JmxServer jmxServer = new JmxServer(9999);
		// NOTE: you could also use the platform mbean server:
		// JmxServer jmxServer = new
		// JmxServer(ManagementFactory.getPlatformMBeanServer());

		// start the server
		jmxServer.start();

		// create a web server publisher listening on a specific port
		JmxWebServer jmxWebServer = new JmxWebServer(8888);
		jmxWebServer.start();

		// create the object we will be exposing with JMX
		RuntimeCounter counter = new RuntimeCounter();
		// register our object
		jmxServer.register(counter);

		// Wait forever
		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);
		// shutdown our server
		jmxServer.stop();
	}
}
