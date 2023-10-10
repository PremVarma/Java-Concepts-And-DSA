package ds.Stack;

class StackImplArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackImplArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int item) {
        if (!isFull()) {
            stackArray[++top] = item;
        } else {
            System.out.println("Stack is full. Cannot push " + item);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty.");
            return -1; // You can change this to throw an exception if desired
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty.");
            return -1; // You can change this to throw an exception if desired
        }
    }

    public int size() {
        return top + 1;
    }
}

