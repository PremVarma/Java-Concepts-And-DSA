package ds.Array.medium;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveLength {
    public static void main(String[] args) {
        int arr[] = {10000,2, 3, 1, 9,11,12,-11,6,6,6};
        System.out.println(findConsecutiveLength(arr));
    }

    private static int findConsecutiveLength(int[] arr) {
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int num : set) {
            int len = 1;
            int next = num + 1;
            while (set.contains(next)) {
                len++;
                next = next + 1;
            }
            max = Math.max(max, len);
        }

        return max;
    }
}
