package basics.multithreading.basics;

import static java.lang.Thread.sleep;

// There are 4 ways of calling thread


public class ThreadDemo {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Way 1 => My Thread is Running..");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Way 2 => My Runnable Thread is Running..");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//TODO: ===========================      Ways of creating threads =======================

//      Using Class which extends Thread
        MyThread myThread = new MyThread();
        myThread.start();

//       Using Runnable Interface
        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();

//       Using Runnable Anonymous class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        sleep(1000);
                        System.out.println("Anonymous Thread Running...");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread runnableAn =  new Thread(runnable,"Anonymous Class Thread");
        runnableAn.start();

//       Using Runnable  class
        Runnable runnableLambda = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    sleep(1000);
                    System.out.println("Running");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        // By default main thread wait for all the thread to finish execution
        Thread thread = new Thread(runnableLambda, "My Thread");
        //thread.setDaemon(true);  // Main thread won't wait for this thread to complete and exit the program
        thread.start();
        thread.join(); // Main thread will wait for this thread to finish program execution
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
        //By calling thread.join(), the main thread will pause and wait for
        // the thread to complete its execution before it continues.
        // This ensures that the main thread doesn't finish before the other thread.
    }
}
