package com.test.threading.completablefuture;


import com.test.threading.completablefuture.service.HelloWorldService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

class CompletableFutureExampleTest {

    CompletableFutureExample cfe = new CompletableFutureExample(new HelloWorldService());

    @Test
    void helloWorldConsumer() {
        CompletableFuture<String> cfhw = cfe.helloWorldConsumer();
        cfhw.thenAccept((result) -> {
            Assertions.assertEquals(result, "HELLO WORLD");
        }).join();
    }

    @Test
    void helloWorld_withSize() {
        CompletableFuture<String> cfhw = cfe.helloWorld_withSize();
        cfhw.thenAccept((result) -> {
            Assertions.assertEquals(result, "11 - HELLO WORLD");
        }).join();
    }

    @Test
    void helloWorld_A2() {
        CompletableFuture<String> cfhw = cfe.helloWorld_A2();
        cfhw.thenAccept((result) -> {
            Assertions.assertEquals(result, "HELLO WORLD!");
        }).join();
    }

    @Test
    void helloWorld_A1() {
        String res = cfe.helloWorld_A1().toUpperCase();
        Assertions.assertEquals(res, "HELLO WORLD!");
    }
}