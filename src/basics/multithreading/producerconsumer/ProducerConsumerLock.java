package basics.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FixedSizeBuffer {
    private final Queue<Integer> buffer;
    private final int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public FixedSizeBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == capacity) {
                // Buffer is full, wait for space
                notFull.await();
            }

            buffer.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signal(); // Notify consumers that the buffer is not empty
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                // Buffer is empty, wait for items
                notEmpty.await();
            }

            int item = buffer.poll();
            System.out.println("Consumed: " + item);
            notFull.signal(); // Notify producers that the buffer is not full
            return item;
        } finally {
            lock.unlock();
        }
    }
}

public class ProducerConsumerLock {
    public static void main(String[] args) {
        FixedSizeBuffer buffer = new FixedSizeBuffer(5);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.consume();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
