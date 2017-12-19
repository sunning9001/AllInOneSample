package com.sample;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Sample2 {

	public static void main(String[] args) {
		Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {

			@Override
			public void subscribe(ObservableEmitter<String> e) throws Exception {
				System.out.println("subscribe");
				e.onNext(Long.toBinaryString(System.currentTimeMillis()));
				e.onComplete();
			}
		});

		observable.subscribe(new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {

				System.out.println("onSubscribe :" + d);

			}

			@Override
			public void onNext(String t) {
				System.out.println("onNext :" + t);

			}

			@Override
			public void onError(Throwable e) {
				System.out.println("onError");

			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");

			}
		});

	}
}
