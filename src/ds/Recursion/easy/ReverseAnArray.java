package ds.Recursion.easy;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseRecc(arr, 0, arr.length - 1); //alternative we can take n-i-1 for right and i>=n/2 for base case
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseRecc(int[] arr, int l, int r) {
        if (l >= r) return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverseRecc(arr, l + 1, r - 1);
    }
}
