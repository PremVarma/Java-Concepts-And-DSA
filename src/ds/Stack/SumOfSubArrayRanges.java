package ds.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubArrayRanges {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println("Sum of ranges: " + subArrayRanges(nums));
    }

    public static long subArrayRanges(int[] nums) {
        return sumOfMax(nums) - sumOfMin(nums);
    }

    // Sum of all subarray maximums
    private static long sumOfMax(int[] nums) {
        int n = nums.length;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) stack.pop();
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            total += (long) nums[i] * left * right;
        }
        return total;
    }

    // Sum of all subarray minimums
    private static long sumOfMin(int[] nums) {
        int n = nums.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Previous Smaller Element


        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            total += (long) nums[i] * left * right;
        }
        return total;
    }
}