package org.example.C02_sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {4,2,1,8,2,9,3};
        for (int i = 0; i <= arr.length-1; i++) {
            int j = i;
            while(j>0 && arr[j-1]>arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
