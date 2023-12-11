package ds.LinkedList.easy;

import ds.LinkedList.Node;

public class ArrayToLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 4, 3};
        Node head = convertArrToLL(arr);
        traversal(head);
        System.out.println("Length of LL => " + lengthOfLL(head));
        System.out.println("Data Exist In LL => " + searchInLL(head,10));
    }


    //-------- TRAVERSAL-----------
    public static void traversal(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    //-------- LENGTH OF LL-----------
    private static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    //-------- SEARCH IN LL-----------
    private static boolean searchInLL(Node head, int element) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == element) return true;
            temp = temp.next;
        }
        return false;
    }

    public static Node convertArrToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            curr.next = temp;
            curr = temp;
        }
        return head;
    }
}
