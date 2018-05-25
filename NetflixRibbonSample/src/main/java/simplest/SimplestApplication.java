package simplest;

import java.net.URI;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import com.netflix.niws.client.http.RestClient;
//https://github.com/Netflix/ribbon/wiki/Getting-Started
public class SimplestApplication {

	public static void main(String[] args) throws Exception {
		//Load the properties file using Archaius ConfigurationManager.
        ConfigurationManager.loadPropertiesFromResources("sample-client.properties");  // 1
        System.out.println(">>>>>>>>>: sample-client.ribbon.listOfServers");
        System.out.println(ConfigurationManager.getConfigInstance().getProperty("sample-client.ribbon.listOfServers"));
        //Use ClientFactory to create client and the load balancer.
        RestClient client = (RestClient) ClientFactory.getNamedClient("sample-client");  // 2
        
        //Build the http request using the builder. Note that we only supply the path part (“/”) of the URI. 
        //The complete URI will be computed by the client once the server is chosen by the load balancer.
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("/")).build(); // 3
        for (int i = 0; i < 20; i++)  {
        	//Call client.executeWithLoadBalancer() API, not the execute() API.
        	HttpResponse response = client.executeWithLoadBalancer(request); // 4
        	System.out.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus());
        }
        ZoneAwareLoadBalancer lb = (ZoneAwareLoadBalancer) client.getLoadBalancer();
        System.out.println("LoadBalancerStats>>>>>>:"+lb.getLoadBalancerStats());
        //Dynamically change the server pool from the configuration.
        ConfigurationManager.getConfigInstance().setProperty(
        		"sample-client.ribbon.listOfServers", "www.linkedin.com:80,www.google.com:80"); // 5
        System.out.println("changing servers ...");
        //Wait until server list is refreshed (2 seconds refersh interval defined in properties file)
        Thread.sleep(3000); // 6
        for (int i = 0; i < 20; i++)  {
        	HttpResponse response = client.executeWithLoadBalancer(request);
        	System.out.println("Status code for " + response.getRequestedURI() + "  : " + response.getStatus());
        }
        //Print out the server stats recorded by the load balancer.
        System.out.println(lb.getLoadBalancerStats()); // 7
	}

}