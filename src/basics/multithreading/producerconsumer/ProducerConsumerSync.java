package basics.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

class FixedSizeBufferSync {
    private final Queue<Integer> buffer;
    private final int capacity;

    public FixedSizeBufferSync(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        int item = buffer.poll();
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}

public class ProducerConsumerSync {
    public static void main(String[] args) {
        FixedSizeBufferSync fixedSizeBufferSync = new FixedSizeBufferSync(5);

        Thread producedThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    fixedSizeBufferSync.produce(i);
                }
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    fixedSizeBufferSync.consume();
                }
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
        });

        producedThread.start();
        consumerThread.start();
    }
}


