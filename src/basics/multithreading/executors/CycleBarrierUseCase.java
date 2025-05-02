package basics.multithreading.executors;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBarrierUseCase {
    public static void main(String[] args) {
        int noOfSubsystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(noOfSubsystems, new Runnable() {
            @Override
            public void run() {
                System.out.println("All subsystems are up and running, System statrtup complete");
            }
        });

        Thread webServer = new Thread(new SubSystem("Web Server", 2000, barrier));
        Thread database = new Thread(new SubSystem("Database", 3000, barrier));
        Thread messagingQueue = new Thread(new SubSystem("Messaging Queue", 2000, barrier));
        Thread redisCache = new Thread(new SubSystem("Cache Service", 3500, barrier));

        webServer.start();
        database.start();
        messagingQueue.start();
        redisCache.start();
    }
}

class SubSystem implements Runnable {
    private final String name;
    private final int initializationTime;
    private final CyclicBarrier barrier;

    public SubSystem(String name, int initializationTime, CyclicBarrier barrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + " : Initilization Started..");
            Thread.sleep(initializationTime);
            System.out.println(this.name + " : Initialization Complete :)");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
        }
    }
}
