package com.sample;

import rx.Observable;
import rx.functions.Action1;

public class QuickStartSample {

	
	public static void main(String[] args) {
		
		
	}
	

	public static void hello(String... names) {
	    Observable.from(names).subscribe(new Action1<String>() {

	        @Override
	        public void call(String s) {
	        	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            System.out.println("Hello " + s + "!");
	        }

	    });
	}
}
