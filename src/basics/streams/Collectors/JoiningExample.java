package basics.streams.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        // Using joining() to concatenate elements into a single String
        String result = fruits.stream()
                .collect(Collectors.joining(", "));

        // Print the result
        System.out.println("Concatenated String: " + result);
    }
}