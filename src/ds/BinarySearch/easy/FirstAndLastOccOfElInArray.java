package ds.BinarySearch.easy;

import java.util.Arrays;

import static ds.BinarySearch.easy.LowerBound.findLowerBound;
import static ds.BinarySearch.easy.UpperBound.findUpperBound;

public class FirstAndLastOccOfElInArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        System.out.println(Arrays.toString(findOccurrence(arr, 15)));
        System.out.println(Arrays.toString(findOccurrenceUsingPlainBS(arr, 15)));
        System.out.println(findTotalOccurrence(arr, 11));
    }

    private static int findTotalOccurrence(int[] arr, int x) {
        int first = findLowerBound(arr, x);
        if (first == -1 || arr[first] != x) return 0;
        return findUpperBound(arr, x) - 1 - first + 1;
    }

    private static int[] findOccurrence(int[] arr, int x) {
        int first = findLowerBound(arr, x);
        if (first == -1 || arr[first] != x) return new int[]{-1, -1};
        return new int[]{first, findUpperBound(arr, x) - 1};
    }

    private static int[] findOccurrenceUsingPlainBS(int[] arr, int x) {
        int first = -1, second = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (first == -1 || arr[first] != x) return new int[]{-1, -1};

        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                second = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{first, second};
    }
}
