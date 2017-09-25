package okhttpsample;



import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestCompletableFuture {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		
		System.out.println("main thread start");
		for (int i = 0; i < 2; i++) {
			long l = i;
			CompletableFuture.supplyAsync(new Supplier<Integer>() {
				@Override
				public Integer get() {
					System.out.println(Thread.currentThread().getName() + ":" + l);
					
					return new Integer((int) l);
				}
			}, cachedThreadPool).thenAccept(new Consumer<Integer>() {
				@Override
				public void accept(Integer t) {
					System.out.println(Thread.currentThread().getName() + ":--->" + t);
				}
			});
		}
		System.out.println("main thread end");
	}
}
