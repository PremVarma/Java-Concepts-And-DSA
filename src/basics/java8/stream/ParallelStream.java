package basics.java8.stream;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
//        Parallel Processing of elements
//        Multiple thread work on parts of stream simultaneously, Most effective on CPU Intensive task/large dataset with independent task
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorials = list.stream().map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for stream: " + (endTime - startTime) + "ms");
//      Using parallel stream
        long startTime1 = System.currentTimeMillis();
        List<Integer> list1 = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorials1 = list.parallelStream().map(ParallelStream::factorial).toList();
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time taken for stream: " + (endTime1 - startTime1) + "ms");
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i < n; i++) {
            result *= i;
        }
        return result;
    }
}
