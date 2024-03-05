package basics.multithreading.producerconsumer.basic;

public class SharedResource {
    boolean itemAvailable = false;

    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by " + Thread.currentThread().getName() + " and invoking all thread which are in waiting state");
        notifyAll();
    }

    public synchronized void consumerItem() {
        System.out.println("Consume method invoked by " + Thread.currentThread().getName());
        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now..");
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Item consume by " + Thread.currentThread().getName());
        itemAvailable = false;

    }

}
