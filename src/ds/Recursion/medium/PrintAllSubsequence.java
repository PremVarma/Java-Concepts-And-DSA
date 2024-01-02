package ds.Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        String str = "312";
        printAllSubsequences(str, "", 0);
        int[] arr = {3, 1, 2};
        generateSubSequence(arr, new ArrayList<>(), 0);
    }

    private static void generateSubSequence(int[] arr, List<Integer> list, int index) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        generateSubSequence(arr, list, index + 1);
        list.remove(list.size() - 1);
        generateSubSequence(arr, list, index + 1);
    }

    private static void printAllSubsequences(String input, String current, int index) {
        if (index == input.length()) {
            System.out.println("-> " + current);
            return;
        }

        printAllSubsequences(input, current + input.charAt(index), index + 1);
        printAllSubsequences(input, current, index + 1);
    }
}
