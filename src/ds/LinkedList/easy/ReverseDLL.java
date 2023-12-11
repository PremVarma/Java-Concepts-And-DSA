package ds.LinkedList.easy;

import ds.LinkedList.dll.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseDLL {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        Node head = ArrayToDLL.convertArrToDLL(arr);
        head = solution_BF(head); //In Terms Of Data
        ArrayToDLL.traverseDLL(head);
        head = solution_BT(head); //In Terms Of Data
        ArrayToDLL.traverseDLL(head);
    }

    static Node reverseDLL(Node head) {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node
        }

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    private static Node solution_BT(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            curr.prev = temp;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static Node solution_BF(Node head) {
        Node temp = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}
