package org.alan.reactive.fluxsink;

import org.alan.reactive.util.ReactiveUtil;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NamePublisher implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = ReactiveUtil.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next("with thread " + thread + ": " + name);
    }
}
