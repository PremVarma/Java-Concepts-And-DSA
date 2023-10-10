package ds.Array.easy;

import java.util.ArrayList;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3};
        int arr2[] = {1,9, 9};
        solution(arr1, arr2);
    }

    private static void solution(int[] arr1, int[] arr2) {
        StringBuilder s = new StringBuilder();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int value1 = arr1[i];
            int value2 = arr2[j];
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            s.append(sum);
            i--;
            j--;
        }

        while (i >= 0) {
            int value1 = arr1[i];
            int sum = value1  + carry;
            carry = sum / 10;
            sum = sum % 10;
            s.append(sum);
            i--;
        }

        while (j >= 0) {
            int value1 = arr2[j];
            int sum = value1  + carry;
            carry = sum / 10;
            sum = sum % 10;
            s.append(sum);
            j--;
        }

        System.out.println(s.reverse());
    }
}
