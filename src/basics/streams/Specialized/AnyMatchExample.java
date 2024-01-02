package basics.streams.Specialized;

import java.util.Arrays;

public class AnyMatchExample {
    public static void main(String[] args) {
        // Example 1: Checking if any element is greater than 5
        int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean anyGreaterThan5 = Arrays.stream(numbers1).anyMatch(num -> num > 5);
        System.out.println("Any element greater than 5? " + anyGreaterThan5);

        // Example 2: Checking if any string starts with "A"
        String[] words = {"Apple", "Banana", "Orange", "Grapes"};
        boolean anyStartsWithA = Arrays.stream(words).anyMatch(word -> word.startsWith("Z"));
        System.out.println("Any word starts with 'A'? " + anyStartsWithA);
    }
}
