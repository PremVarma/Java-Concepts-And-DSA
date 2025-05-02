package basics.multithreading.executors;

import java.util.concurrent.*;

public class Problem {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependentService());
        Future<String> future2 = executorService.submit(new DependentService());
        Future<String> future3 = executorService.submit(new DependentService());

        future1.get();
        future2.get();
        future3.get();

        System.out.println("All dependent service finished. Starting main service");
        executorService.shutdown();

//      CountDownLatch -> To achieve above as it count down and reaches to zero once all executed
        int numberOfServices = 3;
        ExecutorService executorService1 = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices);

        executorService1.submit(new DependentService1(latch));
        executorService1.submit(new DependentService1(latch));
        executorService1.submit(new DependentService1(latch));
        latch.await();

        System.out.println("Main");
        executorService1.shutdown();

//      To Reuse CountDownLatch -> We can use CyclicBarrier
        ExecutorService executorService2 = Executors.newFixedThreadPool(numberOfServices);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfServices);
        executorService2.submit(new DependentService2(cyclicBarrier));
        executorService2.submit(new DependentService2(cyclicBarrier));
        executorService2.submit(new DependentService2(cyclicBarrier));
        executorService2.shutdown();


    }
}

class DependentService implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(2000);
        return "ok";
    }
}

class DependentService1 implements Callable<String> {

    private final CountDownLatch latch;

    public DependentService1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(2000);
            return "ok";
        } finally {
            latch.countDown();
        }
    }
}

class DependentService2 implements Callable<String> {

    private final CyclicBarrier barrier;

    public DependentService2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
        barrier.await(); // Worker thread wait for all task to come in same (This) state then it will start and this do not block main thread
        System.out.println("Thead executed " + Thread.currentThread().getName());
        return "ok";
    }
}
