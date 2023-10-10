package ds.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;


public class LargestArearHistogram {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 6, 3, 2, 4, 2};
        System.out.println(findLargestAreaBF(arr));
        System.out.println(findLargestAreaOP(arr));
    }


    public static int[] findNextSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] findPrevSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int findLargestAreaBF(int[] arr) {
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int left = i, right = i;
            while (left > 0 && arr[left] >= arr[i]) {
                left--;
            }
            while (right < arr.length && arr[right] >= arr[i]) {
                right++;
            }
            area = Math.max(area, (right - left + 1) * arr[i]);
        }
        return area;
    }

    public static int findLargestAreaOP(int[] arr) {
        int maxAns = 0;
        int[] ps = findPrevSmaller(arr);
        int[] ns = findNextSmaller(arr);
        for (int i = 0; i < arr.length; i++) {
            int curr = (ns[i] - ps[i] - 1) * arr[i];
            maxAns = Math.max(maxAns, curr);
        }
        return maxAns;
    }

}
