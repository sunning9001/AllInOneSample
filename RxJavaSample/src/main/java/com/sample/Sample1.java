package com.sample;



import rx.Emitter.BackpressureMode;
import rx.Observable;
import rx.functions.Action1;

public class Sample1 {
	public static void main(String[] args) {

		Observable<Long> observable = Observable.create(emitter -> {
		     
			 System.out.println("emitter onNext");
			 emitter.onNext(System.nanoTime());
			 emitter.onNext(System.nanoTime());

		 }, BackpressureMode.ERROR);
		 
		observable.subscribe(new Action1<Long>() {

			@Override
			public void call(Long t) {
				
				System.out.println("call :" +t);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
}
