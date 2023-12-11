package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

public class DeleteMiddleNodeOfLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = ArrayToLL.convertArrToLL(arr);
        head = deleteMiddleNode(head);
        ArrayToLL.traversal(head);
    }

    private static Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
