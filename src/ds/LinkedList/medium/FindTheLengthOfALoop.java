package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

import java.util.HashMap;
import java.util.HashSet;

public class FindTheLengthOfALoop {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Create Loop Manually
        Node head = ArrayToLL.convertArrToLL(arr);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next.next;
//        int isLoopPresent = solution_OP(head);
        int isLoopPresent = solution_BT(head);
        System.out.println("Length Of Loop => " + isLoopPresent);
    }

    private static int solution_BT(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return findLength(slow, fast);
        }
        return 0;
    }

    private static int findLength(Node slow, Node fast) {
        int count = 1;
        fast = fast.next;
        while (slow != fast) {
            count++;
            fast = fast.next;
        }
        return count;
    }

    private static int solution_OP(Node head) {
        HashMap<Node, Integer> set = new HashMap<>();
        Node temp = head;
        int counter = 1;
        while (temp != null) {
            if (set.containsKey(temp)) return counter - set.get(temp);
            set.put(temp, counter++);
            temp = temp.next;
        }

        return 0;
    }
}
