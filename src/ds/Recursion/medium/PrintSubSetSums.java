package ds.Recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintSubSetSums {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        ArrayList<Integer> result = new ArrayList<>();
        printSubSetSum(arr,  0, 0, result);
        Collections.sort(result);
        System.out.println(result);
    }

    private static void printSubSetSum(int[] arr, int i, int sum, ArrayList<Integer> result) {
        if (i >= arr.length) {
            result.add(sum);
            return;
        }
        printSubSetSum(arr, i + 1, sum + arr[i], result);
        printSubSetSum(arr, i + 1, sum, result);
    }
}
