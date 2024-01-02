package ds.BinarySearch.easy;

import static ds.BinarySearch.easy.LowerBound.findLowerBound;

//Sorted and Distinct find element and if not found . find its inserted position.
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int m = 4;
        System.out.println(searchInsert(arr, m));
    }

    private static int searchInsert(int[] arr, int m) {
        return findLowerBound(arr,m);
    }
}
