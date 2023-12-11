package ds.LinkedList.easy;


import ds.LinkedList.dll.Node;

public class ArrayToDLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 4, 3};
        Node head = convertArrToDLL(arr);
        traverseDLL(head);

    }

    public static void traverseDLL(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " <=> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void traverseBackward(Node head) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.data + " <=> ");
            current = current.prev;
        }
        System.out.print("null");
        System.out.println();
    }

    public static Node convertArrToDLL(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

}
