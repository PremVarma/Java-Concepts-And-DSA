package ds.Stack;

public class LargestSubmatrixWithArea {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1}};
        System.out.println(findLargestRectangle(arr));
    }

    static int findLargestRectangle(int[][] arr) {
        int[] currRow = arr[0];
        int maxAns = LargestArearHistogram.findLargestAreaOP(currRow);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) currRow[j] += 1;
                else currRow[j] = 0;
            }
            int currAns = LargestArearHistogram.findLargestAreaOP(currRow);
            maxAns = Math.max(maxAns, currAns);
        }
        return maxAns;
    }
}
