package ds.Stack;


import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubArrayMax {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        int minBT = findMinSumBT(arr);
        System.out.println("Min Sum: " + minBT);
    }

    private static int findMinSumBT(int[] arr) {
        int[] nse = findNGE(arr);
        int[] pse = findPGE(arr);
        long total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (arr[i] * left % mod * right % mod) % mod) % mod;
        }
        return (int) total;
    }

    private static int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    private static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return result;
    }
}
