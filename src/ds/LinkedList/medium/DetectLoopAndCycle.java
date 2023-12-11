package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

import java.util.HashSet;

public class DetectLoopAndCycle {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Create Loop Manually
        Node head = ArrayToLL.convertArrToLL(arr);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next.next;
//      Solutions
//        boolean isLoopPresent = solution_BF(head);
        boolean isLoopPresent = solution_BT(head);
        System.out.println("Loop Detected => " + isLoopPresent);
    }

    private static boolean solution_BT(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static boolean solution_BF(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (set.contains(temp)) return true;
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
