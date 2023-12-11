package ds.LinkedList.medium;

import ds.LinkedList.dll.Node;
import ds.LinkedList.easy.ArrayToDLL;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = ArrayToDLL.convertArrToDLL(arr);
        head = solution_BF(head, 1);
        ArrayToDLL.traverseDLL(head);
    }

    private static Node solution_BF(Node head, int k) {
        int lengthOfLL = 0;
        Node temp = head;
        while (temp != null) {
            lengthOfLL++;
            temp = temp.next;
        }
        // If They ask to delete head that is k == length
        if (lengthOfLL == k) {
            return head.next;
        }
        temp = head;
        int res = lengthOfLL - k;
        while (temp != null && res != 1) {
            res--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
