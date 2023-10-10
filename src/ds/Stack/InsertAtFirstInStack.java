package ds.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class InsertAtFirstInStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(10);
        stack.push(3);
        stack.push(-3);
//        insertAtFirst(stack,6);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }

    private static void insertAtFirst(Deque<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }
        int temp = stack.poll();
        insertAtFirst(stack, num);
        stack.push(temp);
    }

    //    Reverse Stack
    private static void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) return;
        int num = stack.poll();
        reverse(stack);
        insertAtFirst(stack, num);
    }

    private static void sortedInsert(Deque<Integer> stack, int num) {
        if (stack.isEmpty() || stack.peek() < num) {
            stack.push(num);
            return;
        }
        int temp = stack.poll();
        sortedInsert(stack, num);
        stack.push(temp);
    }

    //    Sort Stack Without Loop
    private static void sort(Deque<Integer> stack) {
        if (stack.isEmpty()) return;
        int num = stack.poll();
        sort(stack);
        sortedInsert(stack, num);
    }
}
