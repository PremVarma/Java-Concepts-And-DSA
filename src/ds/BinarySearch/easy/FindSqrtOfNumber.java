package ds.BinarySearch.easy;

public class FindSqrtOfNumber {
    public static void main(String[] args) {
        System.out.println(findSqrt(50));
    }

    private static int findSqrt(int num) {
        int low = 1, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return mid;
            } else if (mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
