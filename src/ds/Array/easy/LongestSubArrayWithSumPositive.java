package ds.Array.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumPositive {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 1, 1, 1, 5, 1, 9};
        long k = 10;
        int len = solutionBT(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }

    public static int solutionBF(int[] a, long k) {
        int n = a.length; // size of the array.
        int len = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    public static int solutionBT(int[] arr, long k) {
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            long rem = sum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int solution(int[] arr, long k) {

    }
}

