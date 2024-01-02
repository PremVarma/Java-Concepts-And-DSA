package ds.LinkedList.hard;

import ds.LinkedList.Node;
import ds.LinkedList.easy.ArrayToLL;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


public class FlatternLLI {

    static class Node {
        int data;
        Node next;
        Node down;

        Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);
        Node sixteen = new Node(16);
        Node seventeen = new Node(17);


        // set head Node
        Node head = one;

        // set next pointers
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        one.down = six;

        six.next = seven;
        seven.next = eight;

        seven.down = eleven;
        eight.down = twelve;
        twelve.down = fifteen;

        four.down = nine;
        nine.next = ten;
        nine.down = thirteen;
        thirteen.next = fourteen;
        thirteen.down = sixteen;
        sixteen.next = seventeen;

        System.out.println("The original list is :");
        traversal(head);
//        head = flattenBF(head, k);
        head = flattenOP(head);
        System.out.println("The flatten list is :");
        traversal(head);
    }

    private static Node flattenOP(Node head) {
        if (head == null) return null;
        Node curr = head;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        while (curr != tail) {
            if (curr.down != null) {
                tail.next = curr.down;
                Node tmp = curr.down;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void traversal(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    private static Node flattenBF(Node head, int k) {
        Node temp = head;
        Queue<Node> queue = new ArrayDeque<>();
        while (temp != null) {
            if (temp.next == null) {
                temp.next = queue.poll();
            }
            if (temp.down != null) {
                queue.add(temp.down);
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node flattenBT(Node head, int k) {
        Node temp = head;
        Queue<Node> queue = new ArrayDeque<>();
        while (temp != null) {
            if (temp.next == null) {
                temp.next = queue.poll();
            }
            if (temp.down != null) {
                queue.add(temp.down);
            }
            temp = temp.next;
        }
        return head;
    }
}
