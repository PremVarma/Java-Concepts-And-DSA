package basics.streams.Specialized;

import java.util.Arrays;

public class NonMatchExample {
    public static void main(String[] args) {
        // Example 1: Checking if no element is negative
        int[] numbers1 = {1, 2, 3, 4, 5};
        boolean noneNegative = Arrays.stream(numbers1).noneMatch(num -> num < 0);
        System.out.println("No negative elements? " + noneNegative);

        // Example 2: Checking if no string starts with "Z"
        String[] words = {"Apple", "Banana", "Orange", "Grapes"};
        boolean noneStartsWithZ = Arrays.stream(words).noneMatch(word -> word.startsWith("Z"));
        System.out.println("No word starts with 'Z'? " + noneStartsWithZ);
    }
}
