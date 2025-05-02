package basics.multithreading.basics;

class CustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");  // RUNNING
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class LifeCycle {
    public static void main(String[] args) throws InterruptedException {
        CustomThread customThread = new CustomThread();
        System.out.println(customThread.getState()); // NEW
        customThread.start();
        System.out.println(customThread.getState()); // RUNNABLE
        Thread.sleep(100);
        System.out.println(customThread.getState()); // WAITING
        customThread.join();
        System.out.println(customThread.getState()); // TERMINATED
    }
}
