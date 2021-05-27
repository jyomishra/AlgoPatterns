package com.test.threading.producer_consumer;

import java.util.List;

public class Producer {

    List<Integer> queue;
    int limit;
    int value = 0;

    public Producer(List<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    public void produce() throws InterruptedException {
        synchronized (queue) {
            while (true) {
                if (queue.size() == limit) {
                    System.out.println("waiting for list to be consumed");
                    queue.wait();
                } else {
                    System.out.println("Producing values : " + value);
                    queue.add(value);
                    value++;
                    queue.notifyAll();
                }
                Thread.sleep(500);
            }
        }
    }
}
