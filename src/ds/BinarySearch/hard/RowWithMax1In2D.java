package ds.BinarySearch.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowWithMax1In2D {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)));

        int n = 4, m = 5;
        System.out.println("The row with the maximum number of 1's is: " +
                           rowWithMax1sBF(matrix, n, m));

        System.out.println("The row with the maximum number of 1's is: " +
                           rowWithMax1sOP(matrix, n, m));
    }

    private static int lowerBound(List<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int rowWithMax1sOP(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cntMax = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int countOnes = m - lowerBound(matrix.get(i), m, 1);
            if (countOnes > cntMax) {
                cntMax = countOnes;
                index = i;
            }
        }
        return index;
    }

    public static int rowWithMax1sBF(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        // traverse the matrix:
        for (int i = 0; i < n; i++) {
            int cnt_ones = 0;
            for (int j = 0; j < m; j++) {
                cnt_ones += matrix.get(i).get(j);
            }
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }
}
