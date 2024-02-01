package ds.BinarySearch.easy;

public class KthMissingPositiveInteger {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println("Kth missing number: " + findKthPositive(arr, k));
    }

    public static int missingKBF(int[] arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) k++; //shifting k
            else break;
        }
        return k;
    }

    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingNum = arr[mid] - (mid + 1);
            if (missingNum < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[high] + (k - (arr[high] - (high + 1))); // high + k + 1
    }
}
