package ds.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class PreviousAndNextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 20, 15, 3, 12};
        System.out.println("Prev Smaller => ");
        findPrevSmaller(arr);
        System.out.println("Prev Greater => ");
        findGreaterSmaller(arr);
        System.out.println("Next Smaller => ");
        findNextSmaller(arr);
        System.out.println("Next Greater => ");
        findNextGreater(arr);
    }

    private static void findNextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    private static void findNextSmaller(int[] arr) {
        int ans[] = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(ans));
    }

    private static void findGreaterSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    private static void findPrevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.peek());
            }
            stack.push(arr[i]);
        }
    }


}
