package ds.LinkedList.easy;

import ds.LinkedList.Node;

public class DeletionOfNodeLL {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Node head = ArrayToLL.convertArrToLL(arr);
        System.out.println("Remove from head -- ");
        ArrayToLL.traversal(deleteHead(head));
        System.out.println("Remove from tail -- ");
        ArrayToLL.traversal(deleteTail(head));
        System.out.println("Remove Kth element from LL -- ");
        ArrayToLL.traversal(deleteFromPosition(head, 2));
        System.out.println("Remove By value from LL -- ");
        ArrayToLL.traversal(deleteUsingValue(head, 1));
    }

    private static Node deleteFromPosition(Node head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        if (k == 1) {
            head = head.next;
            return head;
        }
        int start = 1;
        Node temp = head;

        while (start < k - 1 && temp.next != null) {
            temp = temp.next;
            start++;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    private static Node deleteUsingValue(Node head, int data) {
        // Handle the case where the head node needs to be deleted
        if (head != null && head.data == data) {
            return head.next;
        }

        Node current = head;
        Node previous = null;

        // Traverse the list to find the node with the specified value
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        // If the node with the specified value is found, remove it
        if (current != null) {
            previous.next = current.next;
        }

        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    private static Node deleteHead(Node head) {
        if (head == null) return head;
        head = head.next;
        return head;
    }
}
