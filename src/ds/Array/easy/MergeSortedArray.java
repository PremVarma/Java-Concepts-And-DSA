package ds.Array.easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6, 8};
        solution(arr1, arr2);
    }

    private static void solution(int[] arr1, int[] arr2) {
        int index_1 = 0, index_2 = 0, index_3 = 0;
        int[] result = new int[arr1.length + arr2.length];
        while (index_1 < arr1.length && index_2 < arr2.length) {
            if (arr1[index_1] < arr2[index_2]) {
                result[index_3++] = arr1[index_1++];
            } else {
                result[index_3++] = arr2[index_2++];
            }
        }

        while (index_1 < arr1.length) {
            result[index_3++] = arr1[index_1];
            index_1++;
        }

        while (index_2 < arr2.length) {
            result[index_3++] = arr2[index_2];
            index_2++;
        }

        System.out.println(Arrays.toString(result));
    }
}
