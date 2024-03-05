package basics.multithreading.producerconsumer.basic;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread t1 =  new Thread(new ProduceTask(sharedResource));
        Thread t2 =  new Thread(new ConsumerTask(sharedResource));

        t1.start();
        t2.start();
    }
}
