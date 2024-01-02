package ds.Recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.print(Arrays.toString(arr));
        int count = mergeSort(arr, 0, arr.length - 1);
        System.out.print(" => " + count);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                count += mid - low + 1;
                right++;
            }
        }

        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }

        return count;
    }
}
