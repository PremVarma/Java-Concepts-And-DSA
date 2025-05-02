package basics.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
    public static void main(String[] args) {
//      Without Executor
        System.out.println("=============================Without Executor=================================");
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalValue = i;
            threads[i - 1] = new Thread(() -> {
                System.out.println(factorial(finalValue));
            });
            threads[i - 1].start();
        }
        for (Thread thread : threads
        ) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime));

//      With Executor
        System.out.println("=============================With Executor=================================");
        long start = System.currentTimeMillis();
        ExecutorService executors = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalValue = i;
            executors.submit(() -> {
                System.out.println(factorial(finalValue));
            });
        }
        executors.shutdown();
        try {
//            executors.awaitTermination(100, TimeUnit.SECONDS); // Wait for 100 seconds
            while (!executors.awaitTermination(1, TimeUnit.SECONDS)) { // Return true if it is terminated and completed
                System.out.println("Waiting..."); // Wait Unlimited
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime));

    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        long result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;
    }
}
