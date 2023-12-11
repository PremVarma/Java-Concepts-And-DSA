package ds.LinkedList.easy;

import ds.LinkedList.dll.Node;

public class DeletionOfNodeDLL {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Node head = ArrayToDLL.convertArrToDLL(arr);
        ArrayToDLL.traverseDLL(head);
        System.out.println("Delete at Head DLL --- ");
        head = deleteAtHead(head);
        ArrayToDLL.traverseDLL(head);
        ArrayToDLL.traverseBackward(head);
        System.out.println("Delete at Tail DLL --- ");
        head = deleteAtTail(head);
        ArrayToDLL.traverseDLL(head);
        System.out.println("Delete of the Kth Element DLL --- ");
        head = deleteAtKthElement(head, 2);
        ArrayToDLL.traverseDLL(head);
        System.out.println("Delete of the Node of DLL --- ");
        head = deleteElement(head, head.next);
        ArrayToDLL.traverseDLL(head);
    }

    private static Node deleteElement(Node head, Node temp) {
        if (head == null) return null;
        Node prev = temp.prev;
        Node next = temp.next;
        if (next == null) {
            prev.next = null;
            temp.prev = null;
            return head;
        }
        prev.next = next;
        next.prev = prev;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    private static Node deleteAtKthElement(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        if (k == 1) {
            return deleteAtHead(head);
        }
        Node current = head;
        int count = 1;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return head;
        }
        Node prev = current.prev;
        Node next = current.next;
        if (next == null) {
            return deleteAtTail(head);
        } else {
            prev.next = next;
            next.prev = prev;
        }
        return head;
    }

    private static Node deleteAtTail(Node head) {
        if (head == null || head.next == null) return null;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        tail.prev = null;
        prev.next = null;
        return head;
    }

    private static Node deleteAtHead(Node head) {
        if (head == null || head.next == null) return null;
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }
}
