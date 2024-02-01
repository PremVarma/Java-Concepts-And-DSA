package ds.BinarySearch.hard;

import java.util.Arrays;

public class PeakElementII {
    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }

    public static int[] findPeakGrid(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = maxElement(arr, n, m, mid);
            int left = mid - 1 >= 0 ? arr[row][mid - 1] : -1;
            int right = mid + 1 < m ? arr[row][mid + 1] : -1;
            if (arr[row][mid] > left && arr[row][mid] > right) {
                return new int[]{row, mid};
            } else if (arr[row][mid] < left) high = mid - 1;
            else low = mid + 1;
        }
        return new int[]{-1, -1};
    }

    private static int maxElement(int[][] arr, int n, int m, int mid) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i][mid] > max) {
                max = arr[i][mid];
                index = i;
            }
        }
        return index;
    }

}
