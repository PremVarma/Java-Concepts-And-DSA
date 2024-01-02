package ds.LinkedList.hard;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;
import ds.LinkedList.medium.ReverseLL;

public class ReverseNodesInKGroupSizeLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = ArrayToLL.convertArrToLL(arr);
        int k = 3;
//        head = reverseNodeInGroup(head, k); // O(N)
        head = reverseNodeInGroupEasy(head, k); // O(N)+)(N)
        ArrayToLL.traversal(head);
    }

    private static Node reverseNodeInGroupEasy(Node head, int k) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        Node prevLast = null;
        while (temp != null) {
            Node kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevLast != null) prevLast.next = temp;
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next = null;
            ReverseLL.reverseRecursive(temp);
            if(temp==head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    private static Node getKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private static Node reverseNodeInGroup(Node head, int k) {
        if (head == null || head.next == null) return head;
        int length = lengthOfLinkedList(head);
        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node pre = dummyHead;
        Node curr, next;
        while (length >= k) {
            curr = pre.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = curr.next;
            }
            pre = curr;
            length -= k;
        }
        return dummyHead.next;
    }

    private static int lengthOfLinkedList(Node head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
