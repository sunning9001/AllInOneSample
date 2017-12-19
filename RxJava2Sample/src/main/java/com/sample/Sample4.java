package com.sample;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Sample4 {
	public static void main(String[] args) {

		Observable<String> hello = Observable.just("hello", "world!");
		hello.subscribe(new Consumer<String>() {
			@Override
			public void accept(String t) throws Exception {
				System.out.println("accept:" + t);
			}
		});
	}
}
