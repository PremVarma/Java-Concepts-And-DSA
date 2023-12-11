package ds.LinkedList.hard;

import ds.LinkedList.dll.Node;
import ds.LinkedList.easy.ArrayToDLL;

public class DeleteAllOccurrenceOfKeyInDLL {
    public static void main(String[] args) {
        int[] arr = {10, 4, 10, 10, 6, 10};
        int key = 10;
        Node head = ArrayToDLL.convertArrToDLL(arr);
        head = deleteOccurrence(head, key);
        ArrayToDLL.traverseDLL(head);
    }

    private static Node deleteOccurrence(Node head, int key) {
        if (head == null) {
            return null; // Empty list
        }

        Node current = head;

        // Traverse the list
        while (current != null) {
            if (current.data == key) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }
            }

            current = current.next;
        }
        return head;
    }
}
