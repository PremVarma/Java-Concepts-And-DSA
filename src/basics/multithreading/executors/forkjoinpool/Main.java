package basics.multithreading.executors.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    public static void main(String[] args) {
        // Create an array for testing
        long[] array = new long[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Create a ForkJoinPool
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        // Create a task to sum the array
        SumTask sumTask = new SumTask(array, 0, array.length);

        // Submit the task to the ForkJoinPool
        long result = forkJoinPool.invoke(sumTask);

        // Print the result
        System.out.println("Sum: " + result);
    }
}

class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10; // Threshold for sequential processing
    private final long[] array;
    private final int start;
    private final int end;

    public SumTask(long[] arr, int start, int end) {
        this.array = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // Perform sequential sum for small arrays
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Divide the task into two subtasks
            int mid = (start + end) / 2;
//            int mid = (start + end) >>> 1;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // Fork the subtasks
            leftTask.fork();
            rightTask.fork();

            // Join the results of subtasks
            return leftTask.join() + rightTask.join();
        }
    }
}
