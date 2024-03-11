package basics.multithreading.executors.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(() -> System.out.println("Hello"), 2, TimeUnit.SECONDS); // Runnable
        Future<String> future = scheduledExecutorService.schedule(() -> "Prem", 3, TimeUnit.SECONDS); // Callable
        Future<?> future1 = scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Running after every 5 sec"), 3, 5, TimeUnit.SECONDS); // Periodic
        Future<?> future2 = scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("Start after every 5 sec of completion"), 3, 5, TimeUnit.SECONDS); // Periodic With Delay


        try {
            System.out.println(future.get());
            Thread.sleep(10000);
            future1.cancel(true);
            future2.cancel(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scheduledExecutorService.shutdown();
    }
}
