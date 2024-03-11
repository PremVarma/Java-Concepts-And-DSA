package basics.multithreading.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Task 1");
            System.out.println("Thread: " + threadLocal.get());
        });

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main thread: " + threadLocal.get());

//      Multiple Threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            threadLocal.set(Thread.currentThread().getName());

//           Work Completed Clean threadpool else other task which uses same thread will retrieve results form this threadpool
            threadLocal.remove();
        });

        for (int i = 0; i < 15; i++) {
            executorService.submit(() -> {
                System.out.println(threadLocal.get());
            });
        }

        executorService.shutdown();
    }
}
