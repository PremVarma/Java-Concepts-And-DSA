package ds.LinkedList.medium;

import ds.LinkedList.dll.Node;
import ds.LinkedList.easy.ArrayToDLL;

public class SortLL012 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 0, 2, 1};
        Node head = ArrayToDLL.convertArrToDLL(arr);
//        head = solution_BF(head); // SC(1), TC(2N)
        ArrayToDLL.traverseDLL(head);
        System.out.println("Better Solution -- ");
        head = solution_BT(head);
        ArrayToDLL.traverseDLL(head);
    }

    private static Node solution_BT(Node head) {
        if (head == null || head.next == null) return head;

        Node dummyZero = new Node(-1), zero = dummyZero;
        Node dummyOne = new Node(-1), one = dummyOne;
        Node dummyTwo = new Node(-1), two = dummyTwo;
        System.out.println(zero);
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = dummyOne.next != null ? dummyOne.next : dummyTwo.next;
        one.next = dummyTwo.next;
        two.next = null;
        return dummyZero.next;
    }

    private static Node solution_BF(Node head) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) cnt0++;
            else if (temp.data == 1) cnt1++;
            else cnt2++;
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (cnt0 != 0) {
                temp.data = 0;
                cnt0--;
            } else if (cnt1 != 0) {
                temp.data = 1;
                cnt1--;
            } else {
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }
        return head;
    }
}
