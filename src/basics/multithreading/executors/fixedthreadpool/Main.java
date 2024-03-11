package basics.multithreading.executors.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//       ===============================FIXED-THREAD-POOL================================================
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> System.out.println("Task 1"));
        executorService.submit(() -> System.out.println("Task 2"));

        // Shutdown the executor when done
        executorService.shutdown();

//       ===============================CACHE-THREAD-POOL================================================
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(() -> System.out.println("Task 1"));
        cachedThreadPool.submit(() -> System.out.println("Task 2"));
        cachedThreadPool.shutdown();

//       ===============================SINGLE-THREAD-POOL================================================
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(() -> System.out.println("Task 1"));
        singleThreadExecutor.submit(() -> System.out.println("Task 2"));
        singleThreadExecutor.shutdown();
    }
}
