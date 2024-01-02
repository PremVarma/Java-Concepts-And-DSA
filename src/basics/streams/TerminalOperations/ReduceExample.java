package basics.streams.TerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "streamlining", "your", "workflow");

        // Concatenate the strings using reduce
        Optional<String> concatenated = words.stream().reduce((s1, s2) -> s1 + " " + s2);

        // Print the result if present
        concatenated.ifPresent(result -> System.out.println("Concatenated String: " + result));
    }
}
