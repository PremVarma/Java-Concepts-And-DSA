package ds.BinarySearch.hard;

public class SearchIn2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3}};
        int target = 6;
        System.out.println(searchIn2dMatrix(matrix, target));
    }

    private static boolean searchIn2dMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
