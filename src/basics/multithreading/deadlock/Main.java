package basics.multithreading.deadlock;

public class Main {

    static class Resource {
        public synchronized void method1(Resource anotherResource) {
            System.out.println(Thread.currentThread().getName() + " is executing method1");

            // Simulate some task
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Trying to access another resource
            anotherResource.method2(this);
        }

        public synchronized void method2(Resource anotherResource) {
            System.out.println(Thread.currentThread().getName() + " is executing method2");

            // Simulate some task
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Trying to access the original resource
            anotherResource.method1(this);
        }
    }

    public static void main(String[] args) {
        final Resource resource1 = new Resource();
        final Resource resource2 = new Resource();

        // Thread 1
        Thread t1 = new Thread(() -> {
            resource1.method1(resource2);
        }, "Thread-1");

        // Thread 2
        Thread t2 = new Thread(() -> {
            resource2.method1(resource1);
        }, "Thread-2");

        t1.start();
        t2.start();
    }

}
