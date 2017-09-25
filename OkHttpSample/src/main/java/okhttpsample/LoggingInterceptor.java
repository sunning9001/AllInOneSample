package okhttpsample;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class LoggingInterceptor implements Interceptor {
	@Override
	public Response intercept(Interceptor.Chain chain) throws IOException {
		Request request = chain.request();

		long t1 = System.nanoTime();

		System.out.println(
				String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));

		Response response = chain.proceed(request);

		long t2 = System.nanoTime();
		System.out.println(String.format("Received response for %s in %.1fms%n%s", response.request().url(),
				(t2 - t1) / 1e6d, response.headers()));

		return response;
	}
	
	public static void main(String[] args) throws IOException {
		
		NetworkInterceptors();
	}
	public static void NetworkInterceptors() throws IOException{
		
		OkHttpClient client = new OkHttpClient.Builder()
			    .addNetworkInterceptor(new LoggingInterceptor())
			    .build();

			Request request = new Request.Builder()
			    .url("http://www.publicobject.com/helloworld.txt")
			    .header("User-Agent", "OkHttp Example")
			    .build();

			Response response = client.newCall(request).execute();
			response.body().close();
	}
	
	public static  void ApplicationInterceptors() throws IOException{
		OkHttpClient client = new OkHttpClient.Builder()
			    .addInterceptor(new LoggingInterceptor())
			    .build();

			Request request = new Request.Builder()
			    .url("http://www.publicobject.com/helloworld.txt")
			    .header("User-Agent", "OkHttp Example")
			    .build();

			Response response = client.newCall(request).execute();
			response.body().close();
	}
}