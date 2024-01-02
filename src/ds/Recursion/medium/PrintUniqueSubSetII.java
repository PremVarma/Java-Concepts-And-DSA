package ds.Recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintUniqueSubSetII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3};
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        printUniqueSubSet(arr, result, new ArrayList<Integer>(), 0);
        System.out.println(result);
    }

    private static void printUniqueSubSet(int[] arr, List<List<Integer>> result, ArrayList<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            list.add(arr[i]);
            printUniqueSubSet(arr, result, list, index + 1);
            list.remove(list.size() - 1);
        }
    }
}
