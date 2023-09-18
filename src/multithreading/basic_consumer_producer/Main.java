package multithreading.basic_consumer_producer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.offer(i); // Add to the queue
                System.out.println("Produced: " + i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Integer value = queue.poll(); // Remove from the queue
                System.out.println("Consumed: " + value);
            }
        });

        producer.start();
        consumer.start();
    }
}
