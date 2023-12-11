package basics.multithreading.basics;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(newRunnable("Task1"));
        executorService.execute(newRunnable("Task2"));
        executorService.execute(newRunnable("Task3"));
//        Future with Runnable
        Future<?> future = executorService.submit(newRunnable("Task 4"));
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

//        Future with callable
        Future<?> callableFuture = executorService.submit(newCallable("Task 5"));
        try {
            String result = (String) callableFuture.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        List<Callable<String>> tasks = Arrays.asList(
                newCallable("Test1"),
                newCallable("Test2"),
                newCallable("Test3")
        );

//    InvokeAny -> Fast execution takes place and return back
        try {
            String result = executorService.invokeAny(tasks);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

//       Invoke All -> execute all task
        try {
            List<Future<String>> results = executorService.invokeAll(tasks);

            for (Future<String> result : results) {
                System.out.println("Result: " + result.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private static Callable newCallable(String task) {
        return () -> {
            System.out.println(Thread.currentThread().getName() + " : " + task);
            return task;
        };
    }

    private static Runnable newRunnable(String task) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : " + task);
            }
        };
    }
}
