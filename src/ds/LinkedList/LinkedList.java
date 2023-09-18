package ds.LinkedList;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    static Node head;

    public static void append(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    static void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void addToHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public static void addToTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public static void add(int val, int position) {
        if (position <= 0) {
            addToHead(val);
            return;
        }
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; i < position && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }


    public static void insertNodeAtPosition(int val, int position) {
        if (position <= 0) {
            return; // Invalid position, nothing to insert.
        }

        if (position == 1) {
            addToHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node current = head;
        int currentPosition = 1;

        while (currentPosition < position - 1 && current != null) {
            current = current.next;
            currentPosition++;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public static void deleteNodeAtPosition(int position) {
        if (position <= 0 || head == null) {
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        int currentPosition = 1;

        while (currentPosition < position - 1 && current.next != null) {
            current = current.next;
            currentPosition++;
        }

        // Check if the position is valid
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static Node reverse() {
        Node prev = null, curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static Node recursiveReverse() {
        if (head == null || head.next == null) {
            return head;
        }
        return head;
    }


    public static void main(String[] args) {
        append(1);
        append(2);
        append(3);
        add(10, 1);
        traverse();
        deleteNodeAtPosition(1);
        add(1, 0);
        insertNodeAtPosition(11, 1);
        traverse();
        head = reverse();
        traverse();

    }
}
