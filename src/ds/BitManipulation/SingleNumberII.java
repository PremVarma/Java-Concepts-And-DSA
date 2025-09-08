package ds.BitManipulation;

import java.util.Arrays;

public class SingleNumberII {
    public static void main(String[] args) {
        int nums[] = {5, 5, 5, 2, 4, 4, 4};
        System.out.println(singleNumberBruteII(nums));
        System.out.println(singleNumberBetterII(nums));
    }

    //    Concept of buckets
    private static int singleNumberBetterII(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos; // add number in ones and should not exists in two
            twos = (twos ^ nums[i]) & ~ones; // add number in twos and it should exist in one
        }
        return ones;
    }

    private static int singleNumberBruteII(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 3) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }
}
