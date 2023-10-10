package ds.Stack;


import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        MyStack queue = new MyStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

class MyStack{
    Queue<Integer> q1 = new ArrayDeque();
    Queue<Integer>  q2= new ArrayDeque();

    void push(int data){
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1.add(data);
        while (!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }

    int pop(){
       return q1.remove();
    }
}

