package ds.BinarySearch.easy;

public class MinInRotateAndSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 1, 1, 2, 3};
        System.out.println(findMinimum(arr));
        System.out.println(findMinimumNonUnique(arr));
    }

    private static int findMinimum(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] < arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int findMinimumNonUnique(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                // The minimum must be in the right half
                low = mid + 1;
            } else if (arr[mid] < arr[high]) {
                // The minimum must be in the left half or is the current element
                high = mid;
            } else {
                // Handle the case when arr[mid] == arr[high]
                high--;
            }
        }
        return arr[low];
    }
}
