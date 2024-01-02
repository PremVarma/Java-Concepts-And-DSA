package ds.Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        combinationSum(arr, target, 0, new ArrayList<>());
    }

    private static void combinationSum(int[] arr, int target, int i, List<Integer> list) {
        if (i >= arr.length) {
            if (target == 0) {
                System.out.println(list);
            }
            return;
        }
        if(arr[i]<=target) {
            list.add(arr[i]);
            combinationSum(arr, target - arr[i], i, list);
            list.remove(list.size() - 1);
        }
        combinationSum(arr, target, i + 1, list);
    }
}
