package ds.Stack;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

public class RemoveMiddleElementFromStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        removeFromMiddle(stack, stack.size(), 0);
        System.out.println(stack);
    }

    private static void removeFromMiddle(Deque<Integer> stack, int length, int count) {
        if (length / 2 == count) {
            stack.pop();
            return;
        }
        int num = stack.poll();
        int cnt = ++count;
        removeFromMiddle(stack, length, cnt);
        stack.push(num);
    }
}
