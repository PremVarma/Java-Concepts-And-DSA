package basics.streams.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Peach", "Pear");

        // Using toMap() with a merge function to concatenate values for the same key
        Map<Integer, String> lengthToNameMap = fruits.stream()
                .collect(Collectors.toMap(
                        String::length,   // key mapper
                        fruit -> fruit,   // value mapper
                        (existing, replacement) -> existing + ", " + replacement));  // merge function optional if you have duplicate keys you need to specify how to resolve

        // Print the result
        System.out.println("Length to Name Map: " + lengthToNameMap);
    }
}