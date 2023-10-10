package ds.LinkedList;


class Node<T> {
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

    public static void reverse() {
        Node prev = null, curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
    }

    // Method to reverse the linked list recursively
    public static Node reverseList(Node current) {
        if (current == null || current.next == null) {
            // If the current node is null or the last node, it becomes the new head.
            head = current;
            return current;
        }
        // Recursively reverse the rest of the linked list
        Node nextNode = reverseList(current.next);
        // Update the next node's next reference to point to the current node (reverse the link)
        nextNode.next = current;
        // Set the current node's next reference to null (end of the reversed list)
        current.next = null;
        return current;
    }

    public static Node reverseRecursive(Node current) {
        if (current == null || current.next == null) {
            head = current;
            return current;
        }
        Node newHead = reverseRecursive(current.next);
        Node headNext = current.next;
        headNext.next = current;
        current.next = null;
        return newHead;
    }

    private static Node findMiddle() {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("middle => " + slow);
        return slow;
    }

    private boolean isPallindrome() {
        if (head == null || head.next == null) {
            return true; // An empty list or a single-node list is a palindrome.
        }
        Node firstHalf = head;
        Node secondHalf = reverseList(findMiddle().next);
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    //    Floyd's Cycle Detection
    private static boolean detectAndRemoveCycle() {
        if (head == null || head.next == null) {
            return false; // No cycle in an empty list or a single-node list.
        }

        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;

        // Move slow one step and fast two steps at a time until they meet or fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected, break out of the loop
                break;
            }
        }

        if (slow != fast) {
            return false;
        }

        // Find the starting node of the cycle
        Node prev = null;
        slow = head;
        while (fast != slow) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
        return true; // Cycle detected and removed
    }


    // Method to create a cycle in the linked list (for testing purposes)
    public static void createCycle(int position) {
        if (head == null) {
            return;
        }

        Node current = head;
        Node tail = null;
        int count = 1;

        while (current.next != null) {
            if (count == position) {
                tail = current;
            }
            current = current.next;
            count++;
        }

        if (tail != null) {
            current.next = tail;
        }
    }

    public static Node cloneLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node clone = new Node<>(current.data);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // Second pass: Update random pointers of cloned nodes
        current = head;
        while (current != null) {
            Node clone = current.next;
            clone.random = (current.random != null) ? current.random.next : null;
            current = clone.next;
        }

        // Third pass: Separate the cloned list from the original list
        Node copy = head.next, temp = head.next;
        Node orig = head;
        while (orig != null) {
            orig.next = orig.next.next;
            copy.next = copy.next.next;
            orig = orig.next;
            copy = copy.next;
        }
        return temp;
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
        reverse();
        traverse();
        reverseRecursive(head);
        traverse();
        findMiddle();
        createCycle(2);
        System.out.println(detectAndRemoveCycle());
        traverse();
    }


}
