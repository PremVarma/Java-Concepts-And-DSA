package ds.BinarySearch.easy;

public class FindSingleElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        System.out.println(searchSingleElement(arr));
    }

    private static int searchSingleElement(int[] arr) {
        if (arr.length == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];
        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            } else if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) { // we are standing on left side and element is on right try dry run
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
