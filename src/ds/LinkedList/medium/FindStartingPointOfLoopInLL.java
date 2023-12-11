package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

import java.util.HashSet;
import java.util.Objects;

public class FindStartingPointOfLoopInLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 15, 3, 4, 5, 6, 7, 8, 9};
//        Create Loop Manually
        Node head = ArrayToLL.convertArrToLL(arr);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next.next;
//        Node result = detectCycleBF(head);
        Node result = detectCycleBT(head);
        System.out.println("Cycle Present At Node " + (result != null ? result.data : 0));

    }

    private static Node detectCycleBT(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    private static Node detectCycleBF(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (set.contains(temp)) return temp;
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
