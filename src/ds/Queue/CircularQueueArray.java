package ds.Queue;

public class CircularQueueArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueueArray(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // You can change this to throw an exception if desired
        }

        int data = queue[front];
        front = (front + 1) % queue.length;
        size--;

        if (isEmpty()) {
            // Reset front and rear when the last element is dequeued
            front = -1;
            rear = -1;
        }

        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // You can change this to throw an exception if desired
        }

        return queue[front];
    }

    public int size() {
        return size;
    }
}

class CircularQueue {
    public static void main(String[] args) {
        CircularQueueArray queue = new CircularQueueArray(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 1
        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 2

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Peek: " + queue.peek()); // Peek: 3
    }
}

