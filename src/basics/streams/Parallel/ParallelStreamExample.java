package basics.streams.Parallel;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential Stream
        long startSequential = System.currentTimeMillis();
        long sumSequential = numbers.stream()
                .mapToLong(n -> square(n))
                .sum();

        long endSequential = System.currentTimeMillis();
        System.out.println("Sequential Sum of Squares: " + sumSequential);
        System.out.println("Sequential Time: " + (endSequential - startSequential) + " ms");

        // Parallel Stream
        long startParallel = System.currentTimeMillis();
        long sumParallel = numbers.parallelStream()
                .mapToLong(n -> square(n))
                .sum();
        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel Sum of Squares: " + sumParallel);
        System.out.println("Parallel Time: " + (endParallel - startParallel) + " ms");
    }

    private static long square(int num) {
        // Simulate a time-consuming operation
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num * num;
    }
}
