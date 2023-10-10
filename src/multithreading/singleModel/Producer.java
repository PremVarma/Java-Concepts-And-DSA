package multithreading.singleModel;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

class Producer implements Runnable {
    private Queue<Integer> queue;
    private int poisonPill;

    public Producer(Queue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = ThreadLocalRandom.current().nextInt(1, 101); // Generate random integers
                System.out.println("Producing: " + value);
                queue.add(value);

                // Simulate some work (e.g., generating values at a certain rate)
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
