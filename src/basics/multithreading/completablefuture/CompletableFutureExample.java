package basics.multithreading.completablefuture;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executed By: " + Thread.currentThread().getName());
            return "Task executed....";
        }, threadPoolExecutor).thenApply((String value) -> {
            System.out.println("QA Deployment Executed By: " + Thread.currentThread().getName());
            return value + " QA Deployment Done....";
        }).thenApplyAsync((String value) -> {
            System.out.println("PROD Deployment Executed By: " + Thread.currentThread().getName());
            return value + " PROD Deployment Done....";
        }, threadPoolExecutor);


//      thenCompose and thenComposeAsync
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Executed By: " + Thread.currentThread().getName());
            return "Deploy Task executed....";
        }, threadPoolExecutor).thenCompose((String value) -> {
            System.out.println("Deployment Started: " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> value + " Deployment Started....");
        }).thenComposeAsync((String value) -> {
            System.out.println("Deployment Done: " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> value + " Deployment Completed....");
        });

//      thenAccept and thenAcceptAsync
        CompletableFuture<Void> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Program Executed By: " + Thread.currentThread().getName());
            return "Closing command started...";
        }, threadPoolExecutor).thenAccept((String value) -> {
            System.out.println("Program Closing: " + Thread.currentThread().getName());
        });

//      thenCombine
        CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<String> completableFuture4 = CompletableFuture.supplyAsync(() -> "Hello World");
        CompletableFuture<String> combineFuture = completableFuture3.thenCombine(completableFuture4, (result1, result2) -> result1 + " : " + result2);

        try {
            System.out.println(completableFuture.get());
            System.out.println(completableFuture1.get());
            System.out.println(completableFuture2.get());
            System.out.println(combineFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        threadPoolExecutor.shutdown();
    }
}
