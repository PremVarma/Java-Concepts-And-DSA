package ds.BinarySearch.medium;

import java.util.Arrays;

public class BloomFlowers {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = roseGarden(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }

    public static boolean possible(int[] arr, int day, int m, int k) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count += 1;
            } else {
                ans += count / k;
                count = 0;
            }
        }
        ans += count / k;
        return ans >= m;
    }

    private static int roseGarden(int[] arr, int k, int m) {
        if (m * k > arr.length) return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int num : arr) {
            low = Math.min(low,num);
            high = Math.max(high,num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
