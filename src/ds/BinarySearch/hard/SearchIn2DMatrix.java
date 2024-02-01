package ds.BinarySearch.hard;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3}};
        int target = 3;
        System.out.println(searchIn2dMatrix(matrix, target));
    }

    private static boolean searchIn2dMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (nums[0] <= target && target <= nums[nums.length - 1]) {
                return binarySearch(nums, target);
            }
        }
        return false;
    }

    private static boolean searchIn2dMatrixOP(int[][] matrix, int n, int m, int target) {
        int low = 0, high = (n * m - 1);
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return true;
            else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
