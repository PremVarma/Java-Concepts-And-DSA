package ds.LinkedList.medium;

import ds.LinkedList.dll.Node;
import ds.LinkedList.easy.ArrayToDLL;

import java.util.ArrayList;

public class OddEvenLL {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6};
        Node head = ArrayToDLL.convertArrToDLL(arr);
//        head = solution_BF(head);
        ArrayToDLL.traverseDLL(head);
        System.out.println("Better Solution --");
        head = solution_BT(head);
        ArrayToDLL.traverseDLL(head);
    }

    private static Node solution_BT(Node head) {
        if (head == null || head.next == null) return head;
        Node odd = head, even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    private static Node solution_BF(Node head) {
        if (head == null || head.next == null) return head;
        ArrayList<Integer> nums = new ArrayList<>();
        Node temp = head;
        while (temp != null && temp.next != null) {
            nums.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) nums.add(temp.data);
        temp = head.next;
        while (temp != null && temp.next != null) {
            nums.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) nums.add(temp.data);

        temp = head;
        int index = 0;
        while (temp != null) {
            temp.data = nums.get(index);
            index++;
            temp = temp.next;
        }
        return head;
    }
}
