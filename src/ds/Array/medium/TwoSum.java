package ds.Array.medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 17;
        int[] ans = solutionII(n, arr, target);
        System.out.println("This is the answer for variant 2: [" + ans[0] + ", "
                + ans[1] + "]");

    }

    private static int[] solution(int n, int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - arr[i])) {
                System.out.println(map.get(target - arr[i]) + "," + i);
                result[0] = arr[map.get(target - arr[i])];
                result[1] = arr[i];
                return result;
            }
            map.put(arr[i], i);
        }
        return result;
    }

    private static int[] solutionII(int n, int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        int[] result = new int[2];
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                result[0] = arr[i];
                result[1] = arr[j];
                return result;
            } else if (sum < target) {
                i++;
            } else j--;
        }
        return result;
    }
}
