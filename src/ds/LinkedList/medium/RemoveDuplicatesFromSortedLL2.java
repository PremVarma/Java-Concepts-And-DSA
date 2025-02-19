package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

public class RemoveDuplicatesFromSortedLL2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3};
        Node head = ArrayToLL.convertArrToLL(arr);
        head = deleteDuplicates(head);
        ArrayToLL.traversal(head);
    }

    public static Node deleteDuplicates(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        while (current != null) {
            if (current.next != null && current.data == current.next.data) {
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
