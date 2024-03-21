package org.alan.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class MapFlatMapTest {
    @Test
    void mapMonoTest() {
        Mono<String> stringMono = Mono.just("Hello world, hello everyone!");

        stringMono.map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    @Test
    void mapFluxTest() {
        Flux<String> stringFlux = Flux.just("Hello", "world,", "hello", "everyone!");

        stringFlux.map(String::toUpperCase)
                .subscribe(System.out::println);

    }

    @Test
    void flatMapMonoTest() {
        Mono<String> stringMono = Mono.just("Hello world, hello everyone!");

        stringMono.flatMap(s -> Mono.just(s.toUpperCase()))
                .subscribe(System.out::println);
    }

    @Test
    void flatMapFluxTest() {
        Flux<String> stringFlux = Flux.just("Hello", "world,", "hello", "everyone!");

        stringFlux.flatMap(s -> Flux.fromArray(s.toUpperCase().split("")))
                .subscribe(System.out::println);
    }
}
