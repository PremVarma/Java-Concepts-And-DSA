package ds.BitManipulation;

import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {2, 4, 2, 6, 3, 7, 7, 3};
        System.out.println(Arrays.toString(twoSingleNumber(nums)));
    }

    //   concepts of buckets
    private static int[] twoSingleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
//      find rightmost set bit
        int rightmost = xor & -xor;
        int b1 = 0, b2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightmost) != 0) {
                b1 = b1^ nums[i];
            } else {
                b2 = b2 ^ nums[i];
            }
        }
        return new int[]{b1, b2};
    }
}
