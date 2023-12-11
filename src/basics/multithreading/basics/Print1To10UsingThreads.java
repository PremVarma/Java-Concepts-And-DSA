package basics.multithreading.basics;


public class Print1To10UsingThreads extends Thread {
    private int number;

    public Print1To10UsingThreads(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " - " + number);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Print1To10UsingThreads(i).start();
        }
    }
}

class SequentialNumberPrinter {
    private static int counter = 1;
    private static final int MAX_NUMBER = 10;

    public static void main(String[] args) {
        Object lock = new Object();

        for (int i = 0; i < MAX_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    int currentNumber = counter;
                    System.out.println("Thread " + Thread.currentThread().getId() + " - " + currentNumber);
                    counter++;
                }
            });

            thread.start();

            try {
                thread.join(); // Wait for the thread to finish before starting the next one
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

