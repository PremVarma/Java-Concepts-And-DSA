package ds.Array.easy;

import java.util.Arrays;

public class LargestElement {

    public static void main(String args[]) {

        int arr1[] = {2, 5, 1, 3, 0};
        System.out.println("The Largest element in the array is: " + sort(arr1));

        int arr2[] = {8, 10, 5, 7, 9};
        System.out.println("The Largest element in the array is: " + solution(arr2));
    }

    static int sort(int arr[]) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    static int solution(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
