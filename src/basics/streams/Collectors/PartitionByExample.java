package basics.streams.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionByExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "cherry", "blueberry");

        // Using partitioningBy() to partition words based on whether their length is greater than 5
        Map<Boolean, List<String>> partitioned = words.stream()
                .collect(Collectors.partitioningBy(word -> word.length() > 5));

        // Print the result
        System.out.println("Partitioned by Length > 5: " + partitioned);
        evenOdd();
    }

    private static void evenOdd(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Using partitioningBy() to partition numbers into even and odd
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        // Print the result
        System.out.println("Partitioned by Even/Odd: " + partitioned);
    }
}
