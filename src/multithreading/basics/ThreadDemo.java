package multithreading.basics;

import static java.lang.Thread.sleep;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
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
        Thread thread = new Thread(runnable,"My Thread");
        //thread.setDaemon(true);  // Main thread won't wait for this thread to complete and exit the program
        thread.start();
        //thread.join(); // Main thread will wait for this thread to finish program execution
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
        //By calling thread.join(), the main thread will pause and wait for
        // the thread to complete its execution before it continues.
        // This ensures that the main thread doesn't finish before the other thread.
    }
}
