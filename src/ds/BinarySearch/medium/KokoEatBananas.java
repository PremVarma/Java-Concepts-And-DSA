package ds.BinarySearch.medium;

import java.util.Arrays;

public class KokoEatBananas {
    public static void main(String[] args) {
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;
        System.out.println(findMinKToSpendH(piles, h));
    }


    private static int findMinKToSpendH(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().orElse(Integer.MIN_VALUE);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long noOfHoursTook = calculateNoOfHours(piles, mid);
            if (noOfHoursTook <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static long calculateNoOfHours(int[] piles, int noOfBananaCanEat) {
        long hours = 0;
        for (int bananas : piles) {
            hours += (long) Math.ceil((double) bananas / noOfBananaCanEat);
        }
        return hours;
    }
}
