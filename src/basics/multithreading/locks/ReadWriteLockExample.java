package basics.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
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
    }
}

class SharedResourceReadWrite {
    boolean isAvailable = false;

    public void producer(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.readLock().lock();
            System.out.println("Read lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            readWriteLock.readLock().unlock();
            System.out.println("Read lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Write lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            readWriteLock.writeLock().unlock();
            System.out.println("Write lock released by: " + Thread.currentThread().getName());
        }
    }
}
