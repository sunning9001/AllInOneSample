package com.example;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;



//A JAX-RS resource is an annotated POJO that provides so-called resource methods that are able to handle HTTP requests for URI paths that the resource is bound to. 
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResourceJDKHttp {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */ 
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}
    //Starting with Java SE 6, Java runtime ships with a built-in lightweight HTTP server.
	// bootstrapping the Grizzly container as well as configuring and deploying the project's JAX-RS application to the container.
	public static void main(String[] args) throws IllegalArgumentException, NullPointerException, IOException, InterruptedException {

		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
		ResourceConfig config = new ResourceConfig(MyResourceJDKHttp.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		Thread.sleep(Integer.MAX_VALUE);

	}
}