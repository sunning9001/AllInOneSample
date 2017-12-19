package com.sample;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class Sample2 {
	public static void main(String[] args) {

		

		// 被观察者将产生100000个事件
		Observable<Integer> observable = Observable.range(1, 100000);
		observable.observeOn(Schedulers.newThread()).subscribe(new Subscriber<Integer>() {
			@Override
			public void onStart() {
				// 一定要在onStart中通知被观察者先发送一个事件
				request(1);
				System.out.println("onStart");
			}

			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(Integer n) {


				// 处理完毕之后，在通知被观察者发送下一个事件
				request(1);
				System.out.println("onNext :" +n);
			}
		});

	}
}
