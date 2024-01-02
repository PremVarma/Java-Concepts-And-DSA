package ds.LinkedList.hard;

public class FlattenWithBottomInSortedLL {
    static class Node {
        int data;
        Node next;
        Node down;

        Node(int data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        Node five = new Node(5);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node ten = new Node(10);
        Node nineteen = new Node(19);
        Node twenty = new Node(20);
        Node twentytwo = new Node(22);
        Node twentyeight = new Node(28);
        Node thirty = new Node(30);
        Node thirtyfive = new Node(35);
        Node forty = new Node(40);
        Node fortyfive = new Node(45);
        Node fifty = new Node(50);


        // set head Node
        Node head = five;

        // set next pointers
        five.down = seven;
        seven.next = eight;
        eight.next = thirty;

        five.next = ten;
        ten.down = twenty;

        ten.next = nineteen;
        nineteen.down = twentytwo;
        twentytwo.down = fifty;

        nineteen.next = twentyeight;
        twentyeight.down = thirtyfive;
        thirtyfive.down = forty;
        forty.down = fortyfive;


        System.out.println("The original list is :");
        traversal(head);
        head = flattenOP(head);
        System.out.println("The flatten list is :");
        printUsingDownPointer(head);
    }

    private static Node mergeTwoLinkedList(Node node, Node next) {
        Node temp = new Node(-1);
        Node result = temp;
        while (node != null && next != null) {
            if (node.data < next.data) {
                temp.down = node;
                temp = temp.down;
                node = node.down;
            } else {
                temp.down = next;
                temp = temp.down;
                next = next.down;
            }
        }
        if (node != null) {
            temp.down = node;
        } else {
            temp.down = next;
        }
        return result.down;
    }

    private static Node flattenOP(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        root.next = flattenOP(root.next);
        root = mergeTwoLinkedList(root, root.next);
        return root;
    }


    private static void printUsingDownPointer(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.down;
        }
        System.out.println("null");
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
}
