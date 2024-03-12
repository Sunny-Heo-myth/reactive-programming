package org.alan.reactive.util;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Slf4j
public class ReactiveUtil {

    private static final Faker FAKER = Faker.instance();

    public static <T> void fluxOnNextErrorComplete(Flux<T> flux) {
        flux.subscribe(
                onNext(),
                onError(),
                onComplete()
        );
    }

    public static <T> void monoOnNextErrorComplete(Mono<T> mono) {
        mono.subscribe(
                onNext(),
                onError(),
                onComplete()
        );
    }

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received : " + o);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("ERROR : " + e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sleepSeconds(int seconds){
        sleepMillis(seconds * 1000);
    }

    public static void sleepMillis(int millis){
        System.out.println("sleep for: " + millis);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber(){
        log.info("DefaultSubscriber!");
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name){
        return new DefaultSubscriber(name);
    }

}
