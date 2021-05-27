package com.test.threading.executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadExecutor {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            ex.submit(new Task(i));
        }

        ex.shutdown();
    }
}
