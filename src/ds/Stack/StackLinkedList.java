package ds.Stack;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (!isEmpty()) {
            int item = top.data;
            top = top.next;
            return item;
        } else {
            System.out.println("Stack is empty.");
            return -1; // You can change this to throw an exception if desired
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty.");
            return -1; // You can change this to throw an exception if desired
        }
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
