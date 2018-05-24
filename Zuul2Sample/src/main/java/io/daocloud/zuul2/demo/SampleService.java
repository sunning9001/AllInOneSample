package io.daocloud.zuul2.demo;

import com.google.inject.Singleton;
import rx.Observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Singleton
public class SampleService {

    private final AtomicBoolean status;

    public SampleService() {
        // change to true for demo
        this.status = new AtomicBoolean(false);
    }

    public boolean isHealthy() {
        return status.get();
    }

    public Observable<String> makeSlowRequest() {
        return Observable.just("test").delay(500, TimeUnit.MILLISECONDS);
    }
}
