package ds.LinkedList.hard;

import ds.LinkedList.dll.Node;
import ds.LinkedList.easy.ArrayToDLL;

public class FindAllPairsWithGivenSumInDLL {
    // Sorted LL
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4};
        Node head = ArrayToDLL.convertArrToDLL(arr);
        int sum = 4;
        findPairsBF(head, sum);
        findPairsBT(head, sum);
    }

    private static void findPairsBT(Node head, int sum) {
        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }
        while (left.data < right.data) {
            if (left.data + right.data == sum) {
                System.out.println(left.data + ", " + right.data);
                left = left.next;
                right = right.prev;
            }
            else if (left.data + right.data < sum) left = left.next;
            else right = right.prev;
        }
    }

    private static void findPairsBF(Node head, int sum) {
        Node temp1 = head;
        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null && (temp1.data + temp2.data <= sum)) {
                if (temp1.data + temp2.data == sum) System.out.println(temp1.data + ", " + temp2.data);
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }
}
