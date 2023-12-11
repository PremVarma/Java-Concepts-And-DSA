package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

public class FindMiddleNode {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        Node head = ArrayToLL.convertArrToLL(arr);
        Node middle = findMiddleOP(head);
        System.out.println("Middle Element => " + middle.data);
    }

    public static Node findMiddleOP(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
