package ds.Array.easy;

import java.util.HashMap;

public class MissingNumberFromArray {
    public static void main(String[] args) {
        int N = 5;
        int a[] = {1, 2, 3, 5};

        int ans = solution(a, N);
        int ans2 = solutionIII(a, N);
        System.out.println("The missing number is: " + ans2);
    }

    private static int solutionIII(int[] a, int N) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result ^ a[i] ^ (i + 1);
        }
        return result ^ N;
    }

    private static int solutionII(int[] a, int N) {
        //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += a[i];
        }
        return sum - s2;
    }

    private static int solution(int[] a, int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < a.length; i++) {
            nums[a[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
