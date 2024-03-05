package basics.multithreading.basics;

public class MonitorLockExample {
    public synchronized void task1() {
        try {
            System.out.println("Task 1 Executing..");
            Thread.sleep(10000);
        } catch (Exception e) {

        }
    }

    public void task2() {
        System.out.println("Task 2 Entry Point..");
        synchronized (this) {
            System.out.println("Task 2 Executing..");
        }
    }

    public void task3() {
        System.out.println("Task 3 Executing...");
    }

    public static void main(String[] args) {
        MonitorLockExample obj1 = new MonitorLockExample();
        MonitorThread1Runnable monitorThread1Runnable =  new MonitorThread1Runnable(obj1);
        Thread t1 = new Thread(monitorThread1Runnable);
        Thread t2 = new Thread(obj1::task2);
        Thread t3 = new Thread(() -> {
            obj1.task3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
