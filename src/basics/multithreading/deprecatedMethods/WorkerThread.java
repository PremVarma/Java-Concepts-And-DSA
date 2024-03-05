package basics.multithreading.deprecatedMethods;

public class WorkerThread extends Thread {
    private volatile boolean stopRequested = false;

    public void run() {
        while (!stopRequested) {
            System.out.println("Lock Aquired and Started Processing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle interruption if needed
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        System.out.println("WorkerThread stopped.");
    }

    public void stopThread() {
        stopRequested = true;
        interrupt(); // Interrupt the thread to wake it up if it's sleeping
    }

    @SuppressWarnings("removal")
    public static void main(String[] args) {
        System.out.println("Main thread started..");
//        WorkerThread workerThread = new WorkerThread();
//        workerThread.start();
//
//        // Let the thread work for some time
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Stop the thread gracefully
//        workerThread.stopThread();

        SharedResource resource = new SharedResource();
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 Calling produce method");
            resource.produce();
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Exception T2 -> " + e.getMessage());
            }
            System.out.println("Thread 2 Calling produce method");
            resource.produce();
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Exception Main -> " + e.getMessage());
        }

        System.out.println("Thread 1 is suspended");
        t1.suspend();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Exception Main 2 -> " + e.getMessage());
        }

        System.out.println("Main thread finished its work..");
    }
}

class SharedResource {
    boolean isAvailable = false;

    public synchronized void produce() {
        System.out.println("Lock Acquired : " + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            System.out.println("Exception => " + e.getMessage());
        }
        System.out.println("Lock release");
    }
}

