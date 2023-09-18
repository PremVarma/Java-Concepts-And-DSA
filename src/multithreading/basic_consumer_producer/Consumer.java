package multithreading.basic_consumer_producer;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private Queue<Integer> queue;
    private int poisonPill;

    public Consumer(Queue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!queue.isEmpty()) {
                    int value = queue.poll();

                    // Check for the poison pill value
                    if (value == poisonPill) {
                        System.out.println("Received poison pill. Exiting.");
                        break;
                    }

                    // Process the value (e.g., print or perform some computation)
                    System.out.println("Consuming: " + value);

                    // Simulate some work (e.g., processing values)
                    Thread.sleep(200);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
