package com.test.threading.producer_consumer;

import java.util.List;

public class Consumer {

    private List<Integer> queue;

    public Consumer(List<Integer> queue) {
        this.queue = queue;
    }

    public void consume() throws InterruptedException {
        System.out.println("Ready to consume");
        synchronized (queue) {
            while (true) {
                if (queue.size() == 0) {
                    System.out.println("Waiting for data to be filled");
                    queue.wait();
                } else {
                    System.out.println("Reading data from queue : " + queue.remove(queue.size() - 1));
                    queue.notifyAll();
                }
                Thread.sleep(500);
            }
        }
    }
}
