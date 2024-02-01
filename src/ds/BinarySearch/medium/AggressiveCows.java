package ds.BinarySearch.medium;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println(aggressiveCows(stalls,k));
    }

    public static int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 1, high = arr[arr.length - 1] - arr[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlace(arr, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static boolean canWePlace(int[] arr, int dist, int cows) {
        int cntCow = 1;
        int lastCowPlaced = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastCowPlaced >= dist) {
                cntCow += 1;
                lastCowPlaced = arr[i];
            }
        }
        return cntCow >= cows;
    }
}
