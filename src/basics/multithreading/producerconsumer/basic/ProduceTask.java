package basics.multithreading.producerconsumer.basic;

public class ProduceTask implements Runnable {
    private final SharedResource sharedResource;

    public ProduceTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer thread " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000l);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        sharedResource.addItem();
    }
}
