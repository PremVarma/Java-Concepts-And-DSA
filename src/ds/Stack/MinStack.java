package ds.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private static Deque<Integer> stack = new ArrayDeque<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(getMin());
    }

    private static boolean getMin() {

        return true;
    }

    private static void push(int value) {
        if (stack.isEmpty()) {
            min = value;
            stack.push(value);
        } else {
            if (value > min) stack.push(value);
            else {
                stack.push(2 * value - min); // get previous min when popped
                min = value;
            }
        }
    }

    private static void pop() {
        if (stack.isEmpty()) return;
        int x = stack.pop();
        if (x < min) {
            min = 2 * min - x;
        }
    }

    private static int top() {
        if (stack.isEmpty()) return -1;
        int x = stack.peek();
        if (min < x) return x;
        return min;
    }
}
