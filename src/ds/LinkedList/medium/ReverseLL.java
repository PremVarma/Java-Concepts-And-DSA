package ds.LinkedList.medium;


import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

public class ReverseLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        Node head = ArrayToLL.convertArrToLL(arr);
        head = reverseIterative(head);
        ArrayToLL.traversal(head);
        System.out.println("Recursive Approach --- ");
        head = reverseRecursive(head);
        ArrayToLL.traversal(head);
    }

    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverseIterative(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
