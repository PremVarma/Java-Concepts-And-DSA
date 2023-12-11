package ds.LinkedList.easy;


import ds.LinkedList.dll.Node;

public class InsertionOfNodeDLL {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5};
        Node head = ArrayToDLL.convertArrToDLL(arr);
        System.out.println("Insertion Of Node at Head --");
        head = insertAtHead(head, 2);
        ArrayToDLL.traverseDLL(head);
        System.out.println("Insertion Before Tail --");
        head = insertBeforeTail(head, 10);
        ArrayToDLL.traverseDLL(head);
        System.out.println("Insertion Before Kth Node --");
        head = insertBeforeKthElement(head, 5, 100);
        ArrayToDLL.traverseDLL(head);
        System.out.println("Insertion Before Node --");
        head = insertBeforeNodeElement(head, head.next.next, 47);
        ArrayToDLL.traverseDLL(head);
    }

    private static Node insertBeforeNodeElement(Node head, Node node, int data) {
        Node prev = node.prev;
        Node newNode = new Node(data, node, prev);
        prev.next = newNode;
        node.prev = newNode;
        return head;
    }

    private static Node insertBeforeKthElement(Node head, int k, int data) {
        if (k == 1) {
            return insertAtHead(head, data);
        }
        int count = 1;
        Node temp = head;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            return head;
        }
        if (temp.next == null) {
            return insertBeforeTail(head, data);
        }
        Node prevEl = temp.prev;
        Node newNode = new Node(data, temp, prevEl);
        prevEl.next = newNode;
        temp.prev = newNode;
        return head;
    }

    private static Node insertBeforeTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        if (tail.prev == null) {
            return insertAtHead(head, data);
        }

        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
        return head;
    }

    private static Node insertBeforeTailII(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        Node newNode = new Node(data, tail, prev);
        prev.next = newNode;
        tail.prev = newNode;
        return head;
    }

    private static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data, head, null);
        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }
}
