package basics.multithreading.locks;

import java.util.concurrent.locks.StampedLock;

//OPTIMISTIC LOCKS
public class StamptedLockExample {
    public static void main(String[] args) {
        StampedSharedResource resource = new StampedSharedResource();

        Thread t1 = new Thread(resource::writeProduce);
        Thread t2 = new Thread(resource::consumer);

        t1.start();
        t2.start();
    }
}

class StampedSharedResource {
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();
    int a = 10;

    public void readProduce() {
        long stamp = lock.readLock();
        try {
            System.out.println("Read lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlockRead(stamp);
        }
    }

    public void writeProduce() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic lock");
            a = 11;
            Thread.sleep(6000);
            if (lock.validate(stamp)) {
                System.out.println("Updated a value successfully");
            } else {
                System.out.println("Rollback of work");
                a = 10; // rollback
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by : " + Thread.currentThread().getId());
        try {
            System.out.println("Performing task...");
            a = 9;
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock released by: " + Thread.currentThread().getName());
        }
    }
}
