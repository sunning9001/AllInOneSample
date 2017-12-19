package sample.defaultFunInterface;

//With Java 8 the same concept of SAM interfaces is recreated and are called Functional interfaces. 
//These can be represented using Lambda expressions, Method reference and constructor references
//There’s an annotation introduced- @FunctionalInterface which can be used for compiler level errors when the interface you have annotated is not a valid Functional Interface. 

public class GreetingSample {
	public static void main(String[] args) {

		GreetingService service = msg -> System.out.println(msg);
		service.sayMessage("你好!");
		
		 new Thread(new Runnable() {
		      @Override
		      public void run() {
		        System.out.println("A thread created and running ...");
		      }
		    }).start();
	}
}
