package ds.Recursion.medium;

import java.util.ArrayList;
import java.util.List;

//-------------------- UNIQUE COMBINATIONS ---------------------- SORT ARR

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2};
        int target = 4;
        List<ArrayList<Integer>> result = new ArrayList<>();
        combinationSum(arr, target, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void combinationSum(int[] arr, int target, int i, ArrayList<Integer> list, List<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1]) continue;
            if (arr[j] > target) break;
            list.add(arr[j]);
            combinationSum(arr, target - arr[j], j + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    private static void combinationSumII(int[] arr, int target, int index, ArrayList<Integer> list, List<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < arr.length && arr[i] <= target; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue; // Skip duplicate elements
            }

            list.add(arr[i]);
            combinationSum(arr, target - arr[i], i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
