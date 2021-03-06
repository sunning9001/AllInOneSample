package okhttpsample;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class PostingStringSample {
	public static final okhttp3.MediaType MEDIA_TYPE_MARKDOWN = okhttp3.MediaType.parse("text/x-markdown; charset=utf-8");

	private final OkHttpClient client = new OkHttpClient();

	public void run() throws Exception {
			  String postBody = ""
			      + "Releases\n"
			      + "--------\n"
			      + "\n"
			      + " * _1.0_ May 6, 2013\n"
			      + " * _1.1_ June 15, 2013\n"
			      + " * _1.2_ August 11, 2013\n";
	
			Request request = new Request.Builder().url("https://api.github.com/markdown/raw")
					.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody)).build();
	
			try (Response response = client.newCall(request).execute()) {
				if (!response.isSuccessful())
					throw new IOException("Unexpected code " + response);
	
				System.out.println(response.body().string());
			}
	}
	
	public static void main(String[] args) throws Exception {
		PostingStringSample  sample =new PostingStringSample();
		sample.run();
	}
}
