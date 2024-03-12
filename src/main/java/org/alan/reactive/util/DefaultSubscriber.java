package org.alan.reactive.util;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name + " - ";
    }

    public DefaultSubscriber() {
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        log.info(name + "Received : " + o);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info(name + "ERROR : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.info(name + "Completed");
    }
}
