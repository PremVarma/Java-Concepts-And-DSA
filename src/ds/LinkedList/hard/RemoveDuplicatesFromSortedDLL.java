package ds.LinkedList.hard;

import ds.LinkedList.dll.Node;
import ds.LinkedList.easy.ArrayToDLL;

public class RemoveDuplicatesFromSortedDLL {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 4, 10, 10};
        Node head = ArrayToDLL.convertArrToDLL(arr);
        head = removeDuplicates(head);
        ArrayToDLL.traverseDLL(head);
    }

    private static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node temp2 = temp.next;
            while (temp2 != null && temp.data == temp2.data) {
                temp2 = temp2.next;
            }

            temp.next = temp2;
            if (temp2 != null) temp2.prev = temp;

            temp = temp.next;
        }
        return head;
    }
}
