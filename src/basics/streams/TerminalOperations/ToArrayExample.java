package basics.streams.TerminalOperations;

import java.util.Arrays;
import java.util.List;

public class ToArrayExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        // Convert the list of fruits to an array
        String[] fruitsArray = fruits.stream().toArray(String[]::new);

        // Print the result
        System.out.println(Arrays.toString(fruitsArray));
    }
}