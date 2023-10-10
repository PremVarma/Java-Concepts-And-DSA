package ds.Array.easy;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 3, 3,4};
        int k = solution(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int solution(int[] arr) {
        int i = 0, j = i + 1;
        for (;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}
