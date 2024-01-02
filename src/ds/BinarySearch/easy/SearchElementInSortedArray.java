package ds.BinarySearch.easy;

//IF Search Space is INT MAX to avoid overflow => start + (high-start)/2
public class SearchElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        System.out.println(findElement(arr, 10));
        System.out.println(findElementIt(arr, 9, 0, arr.length - 1));
    }

    private static int findElement(int[] arr, int el) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == el) {
                System.out.println("Found : " + el + " at index: " + mid);
                return mid;
            } else if (arr[mid] < el) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findElementIt(int[] arr, int el, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == el) {
            return mid;
        } else if (arr[mid] < el) {
            return findElementIt(arr, el, mid + 1, high);
        } else {
            return findElementIt(arr, el, low, mid - 1);
        }
    }
}
