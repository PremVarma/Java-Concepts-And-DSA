package basics.multithreading.cas;

import java.util.concurrent.atomic.AtomicInteger;

//Lock Free Concurrency Solution -> CAS (Read and Perform CAS)
public class CASExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedResource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedResource.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {

        }

        System.out.println("Counter: " + sharedResource.get());
    }
}

class SharedCounterResource {
    int counter = 0;

    public void increment() {
        counter++;
    }

    public int get() {
        return this.counter;
    }
}


class SharedResource {
    AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int get() {
        return counter.get();
    }
}
