package basics.streams.Specialized;

import java.util.Arrays;
import java.util.Optional;

public class FindFirstExample {
    public static void main(String[] args) {
        // Example 1: Finding the first even number
        int[] numbers1 = {1, 3, 5, 2, 4, 6, 7, 8};
        Optional<Integer> firstEven = Arrays.stream(numbers1)
                .filter(num -> num % 2 == 0)
                .boxed()
                .findFirst();
        System.out.println("First even number: " + firstEven.orElse(null));

        // Example 2: Finding the first string starting with "B"
        String[] words = {"Apple", "Banana", "Orange", "Grapes"};
        Optional<String> firstStartsWithB = Arrays.stream(words)
                .filter(word -> word.startsWith("B"))
                .findFirst();
        System.out.println("First word starting with 'B': " + firstStartsWithB.orElse("No match"));
    }
}

