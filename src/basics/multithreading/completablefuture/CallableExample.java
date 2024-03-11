package basics.multithreading.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

//      Case 1 -  Runnable with void
        Future<?> runnableFuture = threadPoolExecutor.submit(() -> System.out.println("Executing task 1..."));
        try {
            Object result = runnableFuture.get();
            System.out.println("Case 1: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//      Case 2 - Runnable with Return workaround
        List<Integer> list = new ArrayList<>();
        Future<List<Integer>> runnableFutureReturn = threadPoolExecutor.submit(() -> {
            list.add(100);
            System.out.println("Executing task 2...");
        }, list);
        try {
            List<Integer> result = runnableFutureReturn.get();
            System.out.println("Case 2: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//      Case 3 - Custom Runnable with Return workaround
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> customRunnableFuture = threadPoolExecutor.submit(new MyRunnable(output), output);
        try {
            List<Integer> result = customRunnableFuture.get();
            System.out.println("Case 3: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//      Case 4 - Callable
        Future<List<Integer>> callableFuture = threadPoolExecutor.submit(() -> {
            System.out.println("Executing task 3...");
            List<Integer> result = new ArrayList<>();
            result.add(1);
            return result;
        });
        try {
            List<Integer> result = callableFuture.get();
            System.out.println("Case 4: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        threadPoolExecutor.shutdown();
    }
}

class MyRunnable implements Runnable {

    private final List<Integer> list;

    public MyRunnable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add(2);
    }
}
