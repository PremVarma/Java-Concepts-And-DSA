package ds.Queue;

import java.util.*;

public class SlidingWindowMaxNumber {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5};
        int k = 3;
        findKMaxElement(arr, k); //nlogk
        findKMaxElement_OP(arr, k); //n
    }

    private static void findKMaxElement_OP(int[] arr, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (; i < arr.length; i++) {
            System.out.println(arr[deque.peek()] + " ");
            // Remove which are out of window
            while (!deque.isEmpty() && deque.peek() < i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
    }

    private static void findKMaxElement(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        for (; i < k; i++) {
            queue.add(arr[i]);
        }
        res.add(queue.peek());
        queue.remove(arr[0]);
        for (; i < arr.length; i++) {
            queue.add(arr[i]);
            res.add(queue.peek());
            queue.remove(arr[i - k + 1]);
        }
        System.out.println(res);
    }
}
