package problems.arrays.easy;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=array
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1}, nums2 = {};
        int m = 1, n = 0;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] =  nums1[i--];
            }else  {
                nums1[k] =  nums2[j--];
            }
            k--;
        }
        while (j>=0) {
            nums1[k] =  nums2[j--];
            k--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
