package okhttpsample;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SynchronousGetSample {
	OkHttpClient client = new OkHttpClient.Builder()
		      .eventListener(new PrintingEventListener(1L, System.nanoTime()))
		      .build();

	public void run() throws Exception {
		Request request = new Request.Builder().url("https://publicobject.com/helloworld.txt").build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			Headers responseHeaders = response.headers();
			for (int i = 0; i < responseHeaders.size(); i++) {
				System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
			}

			System.out.println(response.body().string());
		}
	}

	public static void main(String[] args) throws Exception {
		SynchronousGetSample sample = new SynchronousGetSample();

		sample.run();
	}
}
