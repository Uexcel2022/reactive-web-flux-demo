package com.uexcel.reactivewebfluxdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveWebfluxDemoApplicationTests {

    @Test
    void monoTest() {

        Mono<?> mono = Mono.just("Reactive")
//                .then(Mono.error(new RuntimeException("error occurred")))
                        .log();
        mono.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }

    @Test
    void fluxTest(){
        Flux<String> flux = Flux.just("Spring","Hibernate","SpringBoot","JSp")
//                .concatWith(Flux.error(new RuntimeException("error occurred")))
                        .concatWithValues("AWS").log();

                flux.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
    }
}

