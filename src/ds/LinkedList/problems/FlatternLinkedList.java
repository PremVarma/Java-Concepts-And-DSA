package ds.LinkedList.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FlatternLinkedList {
    public static void main(String[] args) {
        // create individual FlatternNodes and link them together later
        FlatternNode one = new FlatternNode(1);
        FlatternNode two = new FlatternNode(2);
        FlatternNode three = new FlatternNode(3);
        FlatternNode four = new FlatternNode(4);
        FlatternNode five = new FlatternNode(5);
        FlatternNode six = new FlatternNode(6);
        FlatternNode seven = new FlatternNode(7);
        FlatternNode eight = new FlatternNode(8);
        FlatternNode nine = new FlatternNode(9);
        FlatternNode ten = new FlatternNode(10);
        FlatternNode eleven = new FlatternNode(11);
        FlatternNode twelve = new FlatternNode(12);
        FlatternNode thirteen = new FlatternNode(13);
        FlatternNode fourteen = new FlatternNode(14);
        FlatternNode fifteen = new FlatternNode(15);

        // set head FlatternNode
        FlatternNode head = one;

        // set next pointers
        one.next = four;
        four.next = fourteen;
        fourteen.next = fifteen;
        five.next = nine;
        nine.next = ten;
        seven.next = eight;
        eleven.next = thirteen;

        // set down pointers
        one.down = two;
        two.down = three;
        four.down = five;
        five.down = six;
        six.down = seven;
        ten.down = eleven;
        eleven.down = twelve;

        System.out.println("The original list is :");
        printOriginalList(head);

        FlatternNode newhead = flattenList_BF(head);
        System.out.println("\n\nThe flattened list is BF :");
        printFlattenedDownList(newhead);

//        FlatternNode ophead = flattenList_OP(head);
//        System.out.println("\n\nThe flattened list is OP :");
//        printFlattenedList(ophead);
    }

    private static void printFlattenedDownList(FlatternNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.down;
        }
        System.out.println("null");
    }

    // Recursive function to flatten a multilevel linked list
    public static FlatternNode flattenList(FlatternNode head) {
        // base case
        if (head == null) {
            return null;
        }

        // keep track of the next pointer
        FlatternNode next = head.next;

        // process the down list first
        head.next = flattenList(head.down);

        // go to the last node
        FlatternNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // process the next list after the down list
        tail.next = flattenList(next);

        // return head node
        return head;
    }

    //    Approarch 2
    static FlatternNode mergeTwoLL(FlatternNode a, FlatternNode b) {
        FlatternNode temp = new FlatternNode(0);
        FlatternNode res = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.down = a;
                temp = temp.down;
                a = a.down;
            } else {
                temp.down = b;
                temp = temp.down;
                b = b.down;
            }
        }
        if (a != null) {
            temp.down = a;
        }else{
            temp.down = b;
        }

        return res.down;
    }

    public static FlatternNode flattenList_UsingBottomPointer(FlatternNode root) {
        if(root==null || root.next==null){
            return root;
        }
        root.next =  flattenList_UsingBottomPointer(root.next);
        root = mergeTwoLL(root,root.next);
        return root;
    }

    private static FlatternNode flattenList_OP(FlatternNode head) {
        if (head == null) return null;
        FlatternNode tmp = null;
        FlatternNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        FlatternNode curr = head;
        while (curr != tail) {
            if (curr.down != null) {
                tail.next = curr.down;
                tmp = curr.down;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            curr = curr.next;
        }
        return head;
    }

    private static FlatternNode flattenList_BF(FlatternNode head) {
        FlatternNode curr = head;
        Queue<FlatternNode> q = new ArrayDeque<>();
        while (curr != null) {
            if (curr.next == null) {
                curr.next = q.poll();
            }

            if (curr.down != null) {
                q.add(curr.down);
            }
            curr = curr.next;
        }
        return head;
    }

    // Utility function to print a linked list
    public static void printFlattenedList(FlatternNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }


    // Utility function to print a list with `down` and `next` pointers
    public static void printOriginalList(FlatternNode head) {
        if (head == null) {
            return;
        }

        System.out.print(" " + head.data + " ");

        if (head.down != null) {
            System.out.print("[");
            printOriginalList(head.down);
            System.out.print("]");
        }

        printOriginalList(head.next);
    }
}

class FlatternNode {
    int data;
    FlatternNode next;
    FlatternNode down;

    FlatternNode(int data) {
        this.data = data;
    }
}


