package basics.multithreading.completablefuture;


import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<?> future = threadPoolExecutor.submit(() -> {
            try {
                System.out.println("Task starts executing....");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Completed: " + future.isDone());

        try {
            future.get(3, TimeUnit.SECONDS); // Blocks and check for 3 seconds
            System.out.println("Completed After 3 Seconds : " + future.isDone());
        } catch (TimeoutException e) {
            System.out.println("Timeout Exception");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed: " + future.isDone());

        threadPoolExecutor.shutdown();
    }
}
