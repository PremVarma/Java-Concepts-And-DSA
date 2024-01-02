package basics.streams.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "cherry", "blueberry");

        // Using groupingBy() to group words by their length
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        // Print the result
        System.out.println("Grouped by Length: " + groupedByLength);
    }
}
