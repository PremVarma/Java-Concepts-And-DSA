package org.example.C02_sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {4,2,1,8,2,9,3};
        for (int i = 0; i < arr.length-2; i++) {
            int MIN = i;
            for (int j = i; j <= arr.length-1 ; j++) {
                if(arr[j]<arr[MIN]){
                    MIN = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[MIN];
            arr[MIN] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
