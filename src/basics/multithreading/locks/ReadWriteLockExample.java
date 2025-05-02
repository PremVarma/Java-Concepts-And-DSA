package basics.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) throws InterruptedException{
        SharedResourceReadWrite sharedResourceReadWrite = new SharedResourceReadWrite();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(() -> {
            sharedResourceReadWrite.producer(lock);
        });

        Thread t2 = new Thread(() -> {
            sharedResourceReadWrite.producer(lock);
        });

        SharedResourceReadWrite sharedResourceReadWrite1 = new SharedResourceReadWrite();
        Thread t3 = new Thread(() -> {
            sharedResourceReadWrite1.consume(lock);
        });

        t1.start();
        t2.start();
        t3.start();

//     Counter App
        System.out.println("============================COUNTER==========================");
        ReadWriteCounter counter = new ReadWriteCounter();
        Runnable readTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " Read: " + counter.getValue());
            }
        };

        Runnable writeTask = () -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " Incremented ");
            }
        };

        Thread writeT1 = new Thread(writeTask);
        Thread readT1 = new Thread(readTask);
        Thread readT2 = new Thread(readTask);

        writeT1.start();
        readT1.start();
        readT2.start();

        writeT1.join();
        readT1.join();
        readT2.join();
    }
}


class ReadWriteCounter {
    private int counter = 0; // The counter variable
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(); // Lock for synchronization
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    /**
     * Returns the current value of the counter.
     * Multiple threads can read simultaneously.
     */
    public int getValue() {
        readLock.lock(); // Acquire read lock
        try {
            System.out.println(Thread.currentThread().getName() + ": Starting read");
            Thread.sleep(1000); // Simulate a time-consuming read operation
            int value = counter;
            System.out.println(Thread.currentThread().getName() + ": Read value: " + value);
            return value;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1; // Handle interruption gracefully
        } finally {
            System.out.println(Thread.currentThread().getName() + ": Finished read");
            lock.readLock().unlock(); // Release read lock
        }
    }

    /**
     * Increments the counter by 1.
     * Requires exclusive access, blocking all readers and other writers.
     */
    public void increment() {
        writeLock.lock(); // Acquire write lock
        try {
            System.out.println(Thread.currentThread().getName() + ": Starting write");
            Thread.sleep(1000); // Simulate a time-consuming write operation
            counter++;
            System.out.println(Thread.currentThread().getName() + ": Incremented counter");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + ": Finished write");
            lock.writeLock().unlock(); // Release write lock
        }
    }
}

class SharedResourceReadWrite {
    public void producer(ReadWriteLock readWriteLock) {
        try {
            System.out.println("Read lock acquired by: " + Thread.currentThread().getName());
            readWriteLock.readLock().lock();
            Thread.sleep(8000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Read lock released by: " + Thread.currentThread().getName());
            readWriteLock.readLock().unlock();
        }
    }

    boolean isAvailable = false;

    public void consume(ReadWriteLock readWriteLock) {
        try {
            System.out.println("Write lock acquired by: " + Thread.currentThread().getName());
            readWriteLock.writeLock().lock();
            isAvailable = false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Write lock released by: " + Thread.currentThread().getName());
            readWriteLock.writeLock().unlock();
        }
    }
}
