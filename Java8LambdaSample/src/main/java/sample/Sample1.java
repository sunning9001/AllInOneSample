package sample;

public class Sample1 {

	public static void main(String[] args) {
		//Runnable
		// Function<T, R>、Predicate<T> 和 Consumer<T>
		sample1();
	}
	public static void sample2(){
		Thread thread = new Thread(() -> System.out.println("In another thread"));
		thread.start();

		System.out.println("In main");
	}

	public static void sample1() {

		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("In another thread");
			}
		});

		thread.start();

		System.out.println("In main");
		
		
	}
	
}
