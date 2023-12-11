package org.example.C02_sorting;

import java.util.Arrays;
// Pushes maximum at last with each step it gets sorted from last position.
// j will always go n-1,n-2,n-3,n-4.....1 because everytime this array get sorted by 1 position at last
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {4,2,1,8,2,9,3};
        for (int i = arr.length-1; i >= 1; i--) {
            int swap = 0;
            for (int j = 0; j <= i-1 ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = 1;
                }
            }
            if(swap==0){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
