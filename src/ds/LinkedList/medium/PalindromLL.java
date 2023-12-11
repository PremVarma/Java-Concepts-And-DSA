package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

public class PalindromLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 2, 1};
        Node head = ArrayToLL.convertArrToLL(arr);
        boolean isPalindrome = checkIfPalindrome(head);
        System.out.println("Palindrome => " + isPalindrome);
    }

    private static boolean checkIfPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node firstNode = head;
        Node secondNode = ReverseLL.reverseRecursive(slow.next);
        Node initialSecondNode = secondNode;
        while (secondNode != null) {
            if (firstNode.data != secondNode.data) {
                ReverseLL.reverseRecursive(initialSecondNode); // Make LL Original
                return false;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        ReverseLL.reverseRecursive(initialSecondNode); // Make LL Original
        return true;
    }
}
