package ds.LinkedList.hard;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

public class RotateLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = ArrayToLL.convertArrToLL(arr);
        int k = 6;
        head = rotateByK(head, k);
        ArrayToLL.traversal(head);
    }

    private static Node rotateByK(Node head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        if (k % len == 0) return head;
        k = k % len;
        tail.next = head;
        Node nextTail = findNthNode(head, len - k);
        head = nextTail.next;
        nextTail.next = null;
        return head;
    }

    private static Node findNthNode(Node head, int k) {
        int cnt = 1;
        while (head != null) {
            if (cnt == k) return head;
            cnt++;
            head = head.next;
        }
        return head;
    }
}
