import java.util.Optional;

public class Main {
    public static void main(String[] args) {

    }

    public static Node flattern(Node head) {
        if (head == null) {
            return null;
        }
        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
        }
        Node curr = head;
        while (curr != tmp) {
            if (curr.child != null) {
                tmp.next = curr.child;
                Node temp = curr.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                tmp = temp;
            }
            curr = curr.next;
        }
        return head;
    }
}

class Node {
    int data;
    Node next;
    Node child;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}
