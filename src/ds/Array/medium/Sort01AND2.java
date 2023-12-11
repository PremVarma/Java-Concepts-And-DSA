package ds.Array.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort01AND2 {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{0, 2, 1, 2, 0, 1}));
        solutionII(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

    }

    private static void solution(ArrayList<Integer> arr, int n) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                count_0++;
            } else if (arr.get(i) == 1) {
                count_1++;
            } else count_2++;
        }
        for (int i = 0; i < count_0; i++) arr.set(i, 0);
        for (int i = count_0; i < count_0 + count_1; i++) arr.set(i, 1);
        for (int i = count_1 + count_0; i < arr.size(); i++) arr.set(i, 2);
    }

    private static void solutionII(ArrayList<Integer> arr, int n) {
        int zero = 0, one = 0, two = arr.size() - 1;
        while (one <= two) {
            if (arr.get(one) == 0) {
                int temp = arr.get(zero);
                arr.set(zero, arr.get(one));
                arr.set(one, temp);
                zero++;
                one++;
            } else if (arr.get(one) == 2) {
                int temp = arr.get(two);
                arr.set(two, arr.get(one));
                arr.set(one, temp);
                two--;
            } else one++;
        }
        System.out.println(arr);
    }
}
