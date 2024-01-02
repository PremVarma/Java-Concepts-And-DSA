package ds.LinkedList.hard;


public class CloneLLWithRandomPointer {
    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> random;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   ", next=" + next +
                   ", random=" + random +
                   '}';
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + ":");
            if (head.next != null)
                System.out.print(head.next.data);
            else
                System.out.print("NULL");
            if (head.random != null)
                System.out.print("," + head.random.data);
            else
                System.out.print(",NULL");
            System.out.println();
            head = head.next;
        }
    }

    private static Node cloneLL(Node head) {
        if (head == null || head.next == null) return head;
//      Connect Next Pointer
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }

//      Connect Random Pointer
        curr = head;
        while (curr != null) {
            Node clone = curr.next;
            if (curr.random != null) {
                clone.random = curr.random.next;
            }
            curr = clone.next;
        }

//      Separate LL
        Node org = head;
        Node copy = head.next;
        Node temp = head.next;
        while (org.next.next != null) {
            org.next = copy.next;
            copy.next = copy.next.next;
            org = org.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;

        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;
        System.out.println("Original list:(current node:node pointed by next pointer");
        printList(head);
        System.out.println("New list:(current node:node pointed by next pointer");
        printList(cloneLL(head));
    }

}
