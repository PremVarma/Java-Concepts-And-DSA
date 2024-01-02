package basics.streams.Specialized;

import java.util.Arrays;
import java.util.Optional;

public class FindAnyExample {
    public static void main(String[] args) {
        // Example 1: Finding any even number
        int[] numbers1 = {0,1, 3, 5, 2, 4, 6, 7, 8};
        Optional<Integer> anyEven = Arrays.stream(numbers1)
                .filter(num -> num % 2 == 0)
                .boxed()
                .findAny();
        System.out.println("Any even number: " + anyEven.orElse(null));

        // Example 2: Finding any string starting with "B"
        String[] words = {"Apple", "Banana", "Orange", "Grapes"};
        Optional<String> anyStartsWithB = Arrays.stream(words)
                .filter(word -> word.startsWith("B"))
                .findAny();
        System.out.println("Any word starting with 'B': " + anyStartsWithB.orElse("No match"));
    }
}

