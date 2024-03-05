package basics.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        SharedResource resource1 = new SharedResource();
        Thread t1 = new Thread(() -> resource1.performOperation(reentrantLock));

        SharedResource resource2 = new SharedResource();
        Thread t2 = new Thread(() -> resource2.performOperation(reentrantLock));

        SharedResource resource3 = new SharedResource();
        Thread t3 = new Thread(() -> resource3.performOperation(reentrantLock));

        t1.start();
        t2.start();
        t3.start();
    }
}

class SharedResource {
    public void performOperation(ReentrantLock lock) {
        try {
            lock.lock(); // Acquiring the lock
            System.out.println("Lock aquired: " + Thread.currentThread().getId());
            // Critical section - Only one thread can execute this at a time
            System.out.println("Performing operation by Thread: " + Thread.currentThread().getId());
            Thread.sleep(4000);
            // Access shared resource or perform operations requiring mutual exclusion
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Lock released: " + Thread.currentThread().getId());
            lock.unlock(); // Releasing the lock
        }
    }
}
