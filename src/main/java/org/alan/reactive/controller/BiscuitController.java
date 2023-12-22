package org.alan.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BiscuitController {

    @GetMapping("/hello/{requestId}")
    public Mono<String> handle(@PathVariable Long requestId) {
        return Mono.just("hi " + requestId);
    }
}
