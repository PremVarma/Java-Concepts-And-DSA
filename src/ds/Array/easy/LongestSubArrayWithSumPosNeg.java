package ds.Array.easy;

import java.util.HashMap;

public class LongestSubArrayWithSumPosNeg {
    public static void main(String[] args) {
        int[] a = {-1, 1, 1};
        int k = 1;
        int len = solution(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }

    private static int solution(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == k) {
                max = Math.max(max, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                max = Math.max(max, i - map.get(rem));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
