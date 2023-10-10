package ds.Array.medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution2(arr, k, arr.length);
    }

    private static void solution(int[] arr, int k, int n) {
        if (n == 0) return;
        k = k % n;
        int[] temp = new int[k];
        for (int i = n - k; i < n; i++) {
            temp[i - (n - k)] = arr[i];
        }

        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }

        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void solution2(int[] arr, int k, int n) {
        if (n == 0) return;
        int[] temp = new int[n];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + k) % n] = arr[i];
        }
        arr = temp;
        arr = Arrays.copyOf(temp, temp.length);
        System.out.println(Arrays.toString(arr));
    }
}
