package basics.multithreading.locks;

import java.util.concurrent.Semaphore;

public class SemaphoreLockExample {
    public static void main(String[] args) {
        SemaphoreSharedResource resource = new SemaphoreSharedResource();
        Thread t1 = new Thread(resource::produce);
        Thread t2 = new Thread(resource::produce);
        Thread t3 = new Thread(resource::produce);
        Thread t4 = new Thread(resource::produce);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class SemaphoreSharedResource {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void produce() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by: " + Thread.currentThread().getId());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Lock released by: " + Thread.currentThread().getId());
            lock.release();
        }
    }
}
