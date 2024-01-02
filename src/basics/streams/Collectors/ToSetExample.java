package basics.streams.Collectors;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ToSetExample {
    public static void main(String[] args) {
        // Creating a stream with duplicate elements
        String[] colorsArray = {"Red", "Green", "Blue", "Red", "Yellow", "Green"};
        Set<String> distinctColorsSet = Arrays.stream(colorsArray)
                .collect(Collectors.toSet());

        // Print the result
        System.out.println("Distinct Colors Set: " + distinctColorsSet);
    }
}
