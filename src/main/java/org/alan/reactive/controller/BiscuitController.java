package org.alan.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BiscuitController {

    @GetMapping("/hello")
    public Mono<String> handle(@RequestBody Mono<String> request) {
        return request.map(name -> "hello Webflux. My name is " + name + ".");
    }
}
