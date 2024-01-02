package ds.BinarySearch.easy;

import java.util.Arrays;

import static ds.BinarySearch.easy.LowerBound.findLowerBound;

// Floor => largest no in array <= X
//Ceil => smallest no in array >= X
public class FindFloorAndCeilInSortedArr {
    public static void main(String[] args) {
        int[] arr = {10, 20, 25, 40, 50};
        int x = 25;
        int[] ans = findFloorAndCeil(arr, x);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] findFloorAndCeil(int[] arr, int x) {
        int ceil = findLowerBound(arr, x);
        int floor = findFloor(arr, x);
        return new int[]{floor,ceil};
    }

    private static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
