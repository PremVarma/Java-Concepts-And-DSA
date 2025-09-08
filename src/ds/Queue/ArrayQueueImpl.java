package ds.Queue;

public class ArrayQueueImpl {
    private int front, rear, capacity;
    private int[] queue;

    public ArrayQueueImpl(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    // Add element to the queue (enqueue)
    public void enqueue(int item) {
        if (rear == capacity) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear++] = item;
    }

    // Remove element from the queue (dequeue)
    public int dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front++];
        return item;
    }

    // Display elements of the queue
    public void display() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // Return front element
    public int peek() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public static void main(String[] args) {
        ArrayQueueImpl q = new ArrayQueueImpl(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.dequeue();
        q.display();

        System.out.println("Front element: " + q.peek());
    }
}

