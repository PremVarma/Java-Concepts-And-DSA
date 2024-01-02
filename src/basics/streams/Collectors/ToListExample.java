package basics.streams.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToListExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        // Using toList() to collect elements into a List
        List<String> fruitsList = fruits.stream().collect(Collectors.toList());

        // Print the result
        System.out.println("Fruits List: " + fruitsList);
    }
}
