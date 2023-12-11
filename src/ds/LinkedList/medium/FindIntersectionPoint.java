package ds.LinkedList.medium;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

import java.util.HashSet;

public class FindIntersectionPoint {
    public static void main(String[] args) {
        // creation of both lists
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 3);
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec = insertNode(headSec, 3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: ");
        ArrayToLL.traversal(head1);
        System.out.print("List2: ");
        ArrayToLL.traversal(head2);
        //checking if intersection is present
//        Node answerNode = intersectionPresentBF(head1,head2);
//        Node answerNode = intersectionPresentBT(head1, head2); // N1+2N2
        Node answerNode = intersectionPresentBT2(head1, head2); // N1+N2
        System.out.println("Better Approach--");
        if (answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is " + answerNode.data);
    }

    private static Node intersectionPresentBT2(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node t1 = head1;
        Node t2 = head2;
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
            if (t1 == t2) return t1;
            if (t1 == null) t1 = head2;
            if (t2 == null) t2 = head1;
        }
        return t1;
    }

    private static Node intersectionPresentBT(Node head1, Node head2) {
        int diff = getDifference(head1, head2);
        if (diff < 0) while (diff++ != 0) head2 = head2.next;
        else while (diff-- != 0) head1 = head1.next;
        while (head1 != null) {
            if (head1 == head2) return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;
    }

    static int getDifference(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                ++len1;
                head1 = head1.next;
            }
            if (head2 != null) {
                ++len2;
                head2 = head2.next;
            }
        }
        return len1 - len2;
    }

    //utility function to check presence of intersection
    static Node intersectionPresentBF(Node head1, Node head2) {
        HashSet<Node> st = new HashSet<>();
        while (head1 != null) {
            st.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (st.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;

    }

    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }
}
