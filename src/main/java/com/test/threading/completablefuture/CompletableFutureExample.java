package com.test.threading.completablefuture;

import com.test.threading.completablefuture.service.HelloWorldService;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    private HelloWorldService helloWorldService;

    public CompletableFutureExample(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public CompletableFuture<String> helloWorldConsumer() {
        return CompletableFuture.supplyAsync(helloWorldService::helloWorld)
            .thenApply(String::toUpperCase);
    }

    public CompletableFuture<String> helloWorld_withSize() {
        return CompletableFuture.supplyAsync(helloWorldService::helloWorld)
                .thenApply(String::toUpperCase)
                .thenApply((result) -> result.length() + " - " + result);
    }

    public String helloWorld_A1() {
        String hello = helloWorldService.hello();
        String world = helloWorldService.world();
        return hello + world;
    }

    public CompletableFuture<String> helloWorld_A2() {
        CompletableFuture<String>  hello = CompletableFuture.supplyAsync(helloWorldService::hello);
        CompletableFuture<String>  world = CompletableFuture.supplyAsync(helloWorldService::world);

        return hello.thenCombine(world, (h, w) -> h+w).thenApply(String::toUpperCase);
    }
}
