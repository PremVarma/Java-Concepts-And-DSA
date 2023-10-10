package ds.Array.easy;

import java.util.Arrays;

public class MergeSortedArrayII {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 0, 0, 0};
        int[] arr2 = {2, 4, 6};
        solution(arr1, 3, arr2, 3);
    }

    private static void solution(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        System.out.println(Arrays.toString(arr1));
    }
}
