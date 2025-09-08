package problems.arrays.easy;

//https://leetcode.com/problems/remove-element/?envType=problem-list-v2&envId=array
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}

//if (nums == null || nums.length == 0) return 0;
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//        if(nums[i] != val){
//        nums[index++] = nums[i];
//        }
//        }
//        return index;
