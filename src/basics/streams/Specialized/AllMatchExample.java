package basics.streams.Specialized;

import java.util.Arrays;

public class AllMatchExample {
    public static void main(String[] args) {
        // Example 1: Checking if all elements are greater than 0
        int[] numbers1 = {1, 2, 3, 4, 5};
        boolean allGreaterThan0 = Arrays.stream(numbers1).allMatch(num -> num > 0);
        System.out.println("All elements greater than 0? " + allGreaterThan0);

        // Example 2: Checking if all strings have length greater than 3
        String[] words = {"Apple", "Banana", "Orange", "Grapes"};
        boolean allLengthGreaterThan3 = Arrays.stream(words).allMatch(word -> word.length() > 3);
        System.out.println("All words have length greater than 3? " + allLengthGreaterThan3);
    }
}

