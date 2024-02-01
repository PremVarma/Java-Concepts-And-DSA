package ds.BinarySearch.easy;

// Refer find minimum as while finding index of minimum element is the number of rotation example {1,2,3} - count is 0
public class CountRotationOfArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 1};
        System.out.println(countRotation(arr));
    }

    private static int countRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] < arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
