package basics.streams.Numeric;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {
        // Creating IntStream
        IntStream rangeStream = IntStream.range(1, 6);
        IntStream rangeClosedStream = IntStream.rangeClosed(1, 5);
        int[] array = {1, 2, 3, 4, 5};
        IntStream arrayStream = Arrays.stream(array);
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        IntStream mapToIntStream = strings.stream().mapToInt(Integer::parseInt);

        // Sum
        int sum = rangeClosedStream.sum();
        System.out.println("Sum: " + sum);

        // Average
        OptionalDouble average = rangeClosedStream.average();
        average.ifPresent(av -> System.out.println("Average: " + av));

        // Min and Max
        OptionalInt min = rangeClosedStream.min();
        OptionalInt max = rangeClosedStream.max();
        min.ifPresent(mi -> System.out.println("Min: " + mi));
        max.ifPresent(ma -> System.out.println("Max: " + ma));

        // Filter (Print even numbers)
        System.out.print("Even Numbers: ");
        rangeStream.filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));
        System.out.println();

        // Map (Double each element)
        System.out.print("Doubled Numbers: ");
        rangeStream.map(i -> i * 2).forEach(i -> System.out.print(i + " "));
        System.out.println();

        // Boxing to Stream
        System.out.print("Boxed Stream: ");
        rangeStream.boxed().forEach(i -> System.out.print(i + " "));
        System.out.println();

        // Convert to Array
        int[] intArray = rangeStream.toArray();
        System.out.println("Array: " + Arrays.toString(intArray));

        // Convert to List
        List<Integer> intList = rangeStream.boxed().collect(Collectors.toList());
        System.out.println("List: " + intList);
    }
}

