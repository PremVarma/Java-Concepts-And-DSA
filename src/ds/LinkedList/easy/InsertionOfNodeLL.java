package ds.LinkedList.easy;

import ds.LinkedList.Node;

public class InsertionOfNodeLL {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtHead(head,2);
        head = insertAtHead(head,1);
        ArrayToLL.traversal(head);
        System.out.println("Insert at last -- ");
        head = insertAtTail(head,3);
        ArrayToLL.traversal(head);
        System.out.println("Insert at position -- ");
        head = insertAtPosition(head,5,2);
        ArrayToLL.traversal(head);
        System.out.println("Insert Before element X -- ");
        head = insertBeforeValueX(head,4,5);
        ArrayToLL.traversal(head);
    }

    private static Node insertBeforeValueX(Node head, int data, int x) {
        Node newNode = new Node(data);
        if (head == null || head.data == x) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != x) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = newNode;
            newNode.next = current;
        }

        return head;
    }

    private static Node insertAtPosition(Node head, int data, int position) {
        Node newNode =  new Node(data);
        if(head==null) return newNode;
        if(position==1){
            return insertAtHead(head,data);
        }
        int start = 1;
        Node curr = head;
        while(start<position && curr.next!=null){
            curr = curr.next;
            start++;
        }
        if(curr.next!=null) {
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;
        }
        return head;
    }

    private static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);
        if(head==null) return newNode;
        Node curr = head;
        while (curr.next!=null){
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    private static Node insertAtHead(Node head,int data) {
        Node newNode =  new Node(data,head);
        return newNode;
    }
}
