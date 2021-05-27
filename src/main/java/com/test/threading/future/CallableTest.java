package com.test.threading.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ProcessorTask implements Callable<String> {

    private int id;

    public ProcessorTask(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "Excetued the calling method from Task id : " + id;
    }

}

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> fs = ex.submit(new ProcessorTask(i));
            list.add(fs);
        }

        list.forEach(fs -> {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        ex.shutdown();
    }
}
