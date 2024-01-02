package basics.streams.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReducingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using reducing() to calculate the sum of numbers
        Optional<Integer> sum = numbers.stream()
                .collect(Collectors.reducing((a, b) -> a + b));

        // Print the result
        sum.ifPresent(s -> System.out.println("Sum: " + s));
    }
}
