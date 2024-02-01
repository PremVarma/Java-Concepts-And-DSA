package ds.BinarySearch.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BookAllocationProblem {
    public static void main(String[] args) {
        int student = 4;
        ArrayList<Integer> booksWithPages = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        System.out.println(findPages(booksWithPages, student));
    }

    public static int findPages(ArrayList<Integer> arr, int m) {
        int min = 0;
        int max = 0;
        for (int num : arr) {
            min = Math.max(min, num);
            max += num;
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (allocationPossible(arr, mid, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean allocationPossible(ArrayList<Integer> arr, int pages, int m) {
        if (arr.size() < m) return false;
        int student = 1;
        int pagesStudent = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                student += 1;
                pagesStudent = arr.get(i);
            }
        }
        return student <= m;
    }

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for (int pages = low; pages <= high; pages++) {
            if (countStudents(arr, pages) == m) {
                return pages;
            }
        }
        return low;
    }
}
