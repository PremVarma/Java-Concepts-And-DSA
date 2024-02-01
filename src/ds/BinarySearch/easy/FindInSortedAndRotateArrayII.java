package ds.BinarySearch.easy;

public class FindInSortedAndRotateArrayII {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 1, 2, 3, 4, 5, 7};
        System.out.println(findElement(arr, 1));
    }

    private static String findElement(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return "Yes";
            if (arr[low] == arr[mid] && arr[high] == arr[mid]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            // Left Sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right Sorted
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return "No";
    }
}
