package ds.Recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//FIND PERMUTATION => n!
public class PrintAllPermutationOfArrayOrString {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        printAllPermutationBF(arr, res, list, freq);
        System.out.println(res);

        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(arr, 0, result);
        System.out.println("Permutations: " + result);
    }

    private static void printAllPermutationBF(int[] arr, List<List<Integer>> res, List<Integer> list, boolean[] freq) {
        if (list.size() == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                list.add(arr[i]);
                printAllPermutationBF(arr, res, list, freq);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }

    private static void generatePermutations(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            generatePermutations(arr, start + 1, result);
            swap(arr, start, i); // Backtrack
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
