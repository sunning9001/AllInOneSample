package com.sample;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class Sample1 {
	public static void main(String[] args) {

		//producer
        Observable<String> observable = Observable.just("how", "to", "do", "in", "java");
        
      //consumer
        Consumer<? super String> consumer = System.out::println;
        
        //Attaching producer to consumer
        observable.subscribe(new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
				System.out.println("onSubscribe : " +d);
			}

			@Override
			public void onNext(String t) {
				// TODO Auto-generated method stub
				System.out.println("onNext :" +t);
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
				System.out.println("onError :"+e);
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
				
			}});
	}
}
