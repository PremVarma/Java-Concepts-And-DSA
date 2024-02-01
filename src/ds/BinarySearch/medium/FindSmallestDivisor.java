package ds.BinarySearch.medium;

public class FindSmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int[] testCase = {21212, 10101, 12121};
        int threshold = 6;
        int testThreshold = 1000000;
        int smallestDiv = smallestDivisor(testCase, testThreshold);
        System.out.println("Smallest Divisor is: " + smallestDiv);
    }

    public static int smallestDivisor(int[] arr, int threshold) {
        int low = 1, high = Integer.MIN_VALUE;
        for (int num : arr) {
            high = Math.max(high, num);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(arr, threshold, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean possible(int[] arr, int threshold, int divisor) {
        double sum = 0;
        for (int num : arr) {
            sum += Math.ceil((double) num / divisor);
        }
        return sum <= threshold;
    }
}
