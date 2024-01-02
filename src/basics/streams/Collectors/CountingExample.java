package basics.streams.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountingExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        // Using counting() to count the number of elements in the stream
        long count = fruits.stream().collect(Collectors.counting());

        // Print the result
        System.out.println("Number of elements: " + count);
    }
}

