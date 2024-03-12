package org.alan.reactive.fluxsink;

import org.alan.reactive.util.ReactiveUtil;
import reactor.core.publisher.Flux;

public class FluxCreateRefactoring {
    public static void main(String[] args) throws InterruptedException {

        NamePublisher nameFluxSinkConsumer = new NamePublisher();

        Flux.create(nameFluxSinkConsumer)
                .subscribe(ReactiveUtil.subscriber());

//        Thread.sleep(2000);
//        namePublisher.produce();
//        Thread.sleep(2000);
//        namePublisher.produce();
//        Thread.sleep(2000);
//        namePublisher.produce();

        Runnable runnable = nameFluxSinkConsumer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        ReactiveUtil.sleepSeconds(2);
    }
}
