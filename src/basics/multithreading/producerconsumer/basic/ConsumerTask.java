package basics.multithreading.producerconsumer.basic;

public class ConsumerTask implements Runnable {
    SharedResource sharedResource;

    public ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread " + Thread.currentThread().getName());
        sharedResource.consumerItem();
    }
}
