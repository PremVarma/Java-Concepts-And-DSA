package basics.multithreading.executors;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantSimulation {
    // Queue for orders (like DynamoDB items)
    private static final BlockingQueue<String> orderQueue = new ArrayBlockingQueue<>(100);
    // Counter for processed orders
    private static final AtomicInteger ordersProcessed = new AtomicInteger(0);
    // Flag to stop workers
    private static volatile boolean running = true;
    // Counter for unique thread names
    private static final AtomicInteger threadCounter = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        // Create thread pool with 16 daemon threads, each with a unique name
        ExecutorService workers = Executors.newFixedThreadPool(16, r -> {
            Thread t = new Thread(r, "cook-worker-" + threadCounter.getAndIncrement());
            t.setDaemon(true); // Daemon threads exit when JVM stops
            return t;
        });

        // Create latch to wait for 16 workers
        CountDownLatch cooksDone = new CountDownLatch(16);

        // Start 16 workers to process orders
        for (int i = 0; i < 16; i++) {
            workers.submit(() -> {
                try {
                    while (running || !orderQueue.isEmpty()) {
                        String order = orderQueue.poll(500, TimeUnit.MILLISECONDS);
                        if (order != null) {
                            System.out.println(Thread.currentThread().getName() + " processing order: " + order);
                            Thread.sleep(100); // Simulate work (e.g., 100ms per order)
                            ordersProcessed.incrementAndGet();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " finished");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    cooksDone.countDown(); // Signal worker is done
                }
            });
        }

        // Main thread adds orders (like querying DynamoDB)
        for (int i = 1; i <= 50; i++) {
            orderQueue.put("Burger-" + i);
            System.out.println("Main thread added order: Burger-" + i);
        }

        // Simulate finishing querying
        running = false;
        System.out.println("Main thread finished adding orders. Waiting for cooks to finish...");

        // Wait for workers to process remaining orders (up to 10 seconds)
        boolean completed = cooksDone.await(10, TimeUnit.SECONDS);
        if (!completed) {
            System.out.println("Timeout! Some cooks didn't finish. Remaining orders: " + orderQueue.size());
        } else {
            System.out.println("All cooks finished! Total orders processed: " + ordersProcessed.get());
        }

        // Shutdown thread pool
        workers.shutdown();
        try {
            if (!workers.awaitTermination(5, TimeUnit.SECONDS)) {
                workers.shutdownNow();
            }
        } catch (InterruptedException e) {
            workers.shutdownNow();
        }

        System.out.println("Restaurant closed.");
    }
}