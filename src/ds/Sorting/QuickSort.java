package org.example.C02_sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {2,4,6,4,1};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int low, int high){
        if(low<high){
            int pIndex = partition(arr,low,high);
            sort(arr,low,pIndex-1);
            sort(arr,pIndex+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j= high;
        while (i<j){
            while (arr[i]<=pivot && i<=high-1){
                i++;
            }
            while (arr[j]>pivot && j>=low+1){
                j--;
            }

            if(i<j) swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
