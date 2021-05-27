package com.test.threading.executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        long duration = (long) Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task with id " + id + " is in work with Thread-id : " + Thread.currentThread().getName());
    }
}

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            ex.submit(new Task(i));
        }

        ex.shutdown();
    }
}
