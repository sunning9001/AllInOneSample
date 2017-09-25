package okhttpsample;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public class PrintingEventListener extends EventListener {
	public static final Factory FACTORY = new Factory() {
		final AtomicLong nextCallId = new AtomicLong(1L);

		@Override
		public EventListener create(Call call) {
			long callId = nextCallId.getAndIncrement();
			System.out.printf("%04d %s%n", callId, call.request().url());
			return new PrintingEventListener(callId, System.nanoTime());
		}
	};

	final long callId;
	final long callStartNanos;

	public PrintingEventListener(long callId, long callStartNanos) {
		this.callId = callId;
		this.callStartNanos = callStartNanos;
	}

	private void printEvent(String name) {
		long elapsedNanos = System.nanoTime() - callStartNanos;
		System.out.printf("%04d %.3f %s%n", callId, elapsedNanos / 1000000000d, name);
	}

	@Override
	public void callStart(Call call) {
		printEvent("callStart");
	}

	@Override
	public void callEnd(Call call) {
		printEvent("callEnd");
	}
	
	
	
	
	@Override
	public void dnsStart(Call call, String domainName) {
		// TODO Auto-generated method stub
		super.dnsStart(call, domainName);
		printEvent("dnsStart");
	}

	@Override
	public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
		// TODO Auto-generated method stub
		super.dnsEnd(call, domainName, inetAddressList);
		printEvent("dnsEnd");
	}

	@Override
	public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
		// TODO Auto-generated method stub
		super.connectStart(call, inetSocketAddress, proxy);
		printEvent("connectStart");
	}

	@Override
	public void secureConnectStart(Call call) {
		// TODO Auto-generated method stub
		super.secureConnectStart(call);
		printEvent("secureConnectStart");
	}

	@Override
	public void secureConnectEnd(Call call, Handshake handshake) {
		// TODO Auto-generated method stub
		super.secureConnectEnd(call, handshake);
		printEvent("secureConnectEnd");
	}

	@Override
	public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
		// TODO Auto-generated method stub
		super.connectEnd(call, inetSocketAddress, proxy, protocol);
		printEvent("connectEnd");
	}

	@Override
	public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol,
			IOException ioe) {
		// TODO Auto-generated method stub
		super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
		printEvent("connectFailed");
	}

	@Override
	public void connectionAcquired(Call call, Connection connection) {
		// TODO Auto-generated method stub
		super.connectionAcquired(call, connection);
		printEvent("connectionAcquired");
	}

	@Override
	public void connectionReleased(Call call, Connection connection) {
		// TODO Auto-generated method stub
		super.connectionReleased(call, connection);
		printEvent("connectionReleased");
	}

	@Override
	public void requestHeadersStart(Call call) {
		// TODO Auto-generated method stub
		super.requestHeadersStart(call);
		printEvent("requestHeadersStart");
	}

	@Override
	public void requestHeadersEnd(Call call, Request request) {
		// TODO Auto-generated method stub
		super.requestHeadersEnd(call, request);
		printEvent("requestHeadersEnd");
	}

	@Override
	public void requestBodyStart(Call call) {
		// TODO Auto-generated method stub
		super.requestBodyStart(call);
		printEvent("requestBodyStart");
	}

	@Override
	public void requestBodyEnd(Call call, long byteCount) {
		// TODO Auto-generated method stub
		super.requestBodyEnd(call, byteCount);
		printEvent("requestBodyEnd");
	}

	@Override
	public void responseHeadersStart(Call call) {
		// TODO Auto-generated method stub
		super.responseHeadersStart(call);
		printEvent("responseHeadersStart");
	}

	@Override
	public void responseHeadersEnd(Call call, Response response) {
		// TODO Auto-generated method stub
		super.responseHeadersEnd(call, response);
		printEvent("responseHeadersEnd");
	}

	@Override
	public void responseBodyStart(Call call) {
		// TODO Auto-generated method stub
		super.responseBodyStart(call);
		printEvent("responseBodyStart");
	}

	@Override
	public void responseBodyEnd(Call call, long byteCount) {
		// TODO Auto-generated method stub
		super.responseBodyEnd(call, byteCount);
		printEvent("responseBodyEnd");
	}

	@Override
	public void callFailed(Call call, IOException ioe) {
		// TODO Auto-generated method stub
		super.callFailed(call, ioe);
		printEvent("callFailed");
	}

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient.Builder()
			      .eventListener(new PrintingEventListener(1L, System.nanoTime()))
			      .build();
		 
		Request request = new Request.Builder()
			    .url("https://publicobject.com/helloworld.txt")
			    
			    .build();

			System.out.println("REQUEST 1 (new connection)");
			try (Response response = client.newCall(request).execute()) {
			  // Consume and discard the response body.
			  response.body().source().readByteString();
			}

			System.out.println("REQUEST 2 (pooled connection)");
			try (Response response = client.newCall(request).execute()) {
			  // Consume and discard the response body.
			  response.body().source().readByteString();
			}
	}
}
