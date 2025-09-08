package ds.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubArrayMin {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        int min = findMinSumBF(arr);
        System.out.println("Min Sum: " + min);

        int minBT = findMinSumBT(arr);
        System.out.println("Min Sum: " + minBT);
    }

    private static int findMinSumBT(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        System.out.println("NSE: " + Arrays.toString(nse));
        System.out.println("PSE: " + Arrays.toString(pse));
        long total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (arr[i] * left % mod * right % mod) % mod) % mod;
        }
        return (int) total;
    }

    private static int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    private static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return result;
    }

    private static int findMinSumBF(int[] arr) {
        int sum = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % mod;
            }
        }
        return sum;
    }
}
