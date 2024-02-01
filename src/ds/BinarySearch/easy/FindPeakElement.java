package ds.BinarySearch.easy;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeak(arr);

        if (peakIndex != -1) {
            System.out.println("Peak element found at index: " + peakIndex);
        } else {
            System.out.println("No peak element found.");
        }
    }

    private static int findPeak(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;
        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
