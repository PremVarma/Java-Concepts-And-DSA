package basics.multithreading.singleModel;

import java.util.Queue;

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

                    System.out.println("Consuming: " + value);

                    Thread.sleep(200);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
