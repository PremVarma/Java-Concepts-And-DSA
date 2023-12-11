package basics.multithreading.memorymodal;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Data FLOW
// Thread (read write)-> CPU Registers (read write)->L1, L2, L3 cache (R,W) -> RAM -> HEAP

public class Main {
    private static int sharedValue = 0; // Shared data in the heap
    private static AtomicInteger atomic = new AtomicInteger(0); // Shared data in the heap
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(() -> {
            // Access shared data in the heap
            for (int i = 0; i < 10000; i++) {
                sharedValue++;
            }
        });

        Thread thread2 = new Thread(() -> {
            // Access shared data in the heap
            for (int i = 0; i < 10000; i++) {
                sharedValue--;
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final shared value
        System.out.println("Final Shared Value: " + sharedValue);
        sharedValue = 0;
        syncMethod();
        atomic();
        sharedValue = 0;
        usingLock();
    }


//In this code example:
//sharedValue is a shared variable in the heap that both thread1 and thread2 access.
//The two threads increment and decrement sharedValue in a loop, simulating shared data access.
//The interactions with the heap and shared data in the memory model are highlighted.
//You may notice that without proper synchronization, the final value of sharedValue can be unpredictable.
// This demonstrates the importance of using synchronization mechanisms, like synchronized blocks
// or other techniques, to ensure consistent and thread-safe access to shared data in the heap.
//Understanding the interplay between thread stack (for local data), heap memory (for shared data),
// and CPU caches is essential for writing efficient and reliable multi-threaded Java programs.
// Proper synchronization and memory management techniques are crucial to address the challenges that arise when
// multiple threads access shared data.

    // Fixes
//Using synchronize block
    public static void syncMethod() {
        // Create two threads
        Thread thread1 = new Thread(() -> {
            // Use synchronized block to ensure exclusive access
            for (int i = 0; i < 100000; i++) {
                synchronized (Main.class) {
                    sharedValue++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            // Use synchronized block to ensure exclusive access
            for (int i = 0; i < 100000; i++) {
                synchronized (Main.class) {
                    sharedValue--;
                }
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final shared value
        System.out.println("Final Shared Value: " + sharedValue);
    }

    //    Using Atmic Integer
    public static void atomic() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                atomic.incrementAndGet();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                atomic.decrementAndGet();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Shared Value: " + atomic.get());
    }

    //    Using external lock
    public static void usingLock() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                try {
                    sharedValue++;
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                try {
                    sharedValue--;
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Shared Value: " + sharedValue);
    }
}