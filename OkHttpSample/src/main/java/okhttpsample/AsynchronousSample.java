package okhttpsample;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AsynchronousSample {
	private final OkHttpClient client = new OkHttpClient();

	public void run() throws Exception {
		Request request = new Request.Builder().url("http://publicobject.com/helloworld.txt").build();

		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				try (ResponseBody responseBody = response.body()) {
					if (!response.isSuccessful())
						throw new IOException("Unexpected code " + response);

					Headers responseHeaders = response.headers();
					for (int i = 0, size = responseHeaders.size(); i < size; i++) {
						System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
					}

					System.out.println(responseBody.string());
				}
			}
		});
	}
	
	public static void main(String[] args) throws Exception {
		
		AsynchronousSample sample =new AsynchronousSample();
		
		sample.run();
		
		int i =1;
		
		if(i ==1){
			i=2;
			System.out.println(i);
		}
		else if(i ==2){
			System.out.println(i);
		}
	}
}
