package ds.LinkedList.medium;

import ds.LinkedList.dll.Node;
import ds.LinkedList.easy.ArrayToDLL;

public class Add2NumbersInLL {
    public static void main(String[] args) {
        int arr[] = {3, 5};
        int arr1[] = {4, 5, 9, 9};
        Node head1 = ArrayToDLL.convertArrToDLL(arr);
        Node head2 = ArrayToDLL.convertArrToDLL(arr1);
        Node head = solution(head1, head2);
    }

    private static Node solution(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node l1 = head1, l2 = head2;
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
