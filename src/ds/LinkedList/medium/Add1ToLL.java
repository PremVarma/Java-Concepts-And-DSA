package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

public class Add1ToLL {
    public static void main(String[] args) {
        int[] arr = {9, 8, 8, 9};
        Node head = ArrayToLL.convertArrToLL(arr);
        head = solution_BF(head);
        ArrayToLL.traversal(head);
        System.out.println("Better Solution -- ");
        head = addOneBT(head);
        ArrayToLL.traversal(head);
    }

    private static int addOneHelper(Node head) {
        if (head == null) return 1;
        int carry = addOneHelper(head.next);
        head.data = head.data + carry;
        if (head.data < 10) return 0;
        head.data = 0;
        return 1;
    }

    private static Node addOneBT(Node head) {
        int carry = addOneHelper(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static Node addOne_BF(Node head) {
        head = ReverseLL.reverseIterative(head);

        Node current = head;
        int carry = 1;
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                break;
            }
            current = current.next;
        }
        return ReverseLL.reverseIterative(head);
    }


    private static Node solution_BF(Node head) {
        int carry = 1;
        head = ReverseLL.reverseIterative(head);
        Node temp = head;
        while (temp != null) {
            temp.data = temp.data + carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if (carry == 1) {
            Node node = new Node(carry);
            head = ReverseLL.reverseIterative(head);
            node.next = head;
            return node;
        }
        return ReverseLL.reverseRecursive(head);
    }
}
