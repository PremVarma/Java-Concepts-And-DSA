package basics.multithreading.executors.threadpool;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new MyThreadFactory(),
                new MyRejectHandler());

//        Will work for 6 tasks as they are submitted and we have two min and 4 max threads with a queue of 2 but if we exceeds that queue size it will be rejected
        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Task submitted: " + Thread.currentThread().getName());
                } catch (Exception e) {

                }
                System.out.println("Task processed by: " + Thread.currentThread().getName());
            });
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.shutdown();
    }
}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

class MyRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Rejected Execution: " + r.toString());
    }
}
