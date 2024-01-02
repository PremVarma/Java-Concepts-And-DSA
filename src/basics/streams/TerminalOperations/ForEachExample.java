package basics.streams.TerminalOperations;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using forEach to print each name
        names.stream().forEach(name -> System.out.println("Hello, " + name + "!"));
    }
}

