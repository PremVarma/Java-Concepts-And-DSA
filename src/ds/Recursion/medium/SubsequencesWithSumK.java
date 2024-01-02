package ds.Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 2;
        printSubSequencesWithSumK(arr, new ArrayList<>(), 0, 0);
        System.out.println(printFirstSubSequencesWithSumK(arr, new ArrayList<>(), 0, 0));
        System.out.println(countSubSequencesWithSumK(arr, new ArrayList<>(), 0, 0));
    }

    private static void printSubSequencesWithSumK(int[] arr, ArrayList<Integer> list, int index, int sum) {
        if (index == arr.length) {
            if (sum == 2) {
                System.out.println(list);
            }
            return;
        }
        list.add(arr[index]);
        sum += arr[index];
        printSubSequencesWithSumK(arr, list, index + 1, sum);
        list.remove(list.size() - 1);
        sum -= arr[index];
        printSubSequencesWithSumK(arr, list, index + 1, sum);
    }

    private static boolean printFirstSubSequencesWithSumK(int[] arr, ArrayList<Integer> list, int index, int sum) {
        if (index == arr.length) {
            if (sum == 2) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        sum += arr[index];
        if (printFirstSubSequencesWithSumK(arr, list, index + 1, sum)) return true;

        list.remove(list.size() - 1);
        sum -= arr[index];
        return printFirstSubSequencesWithSumK(arr, list, index + 1, sum);
    }

    private static int countSubSequencesWithSumK(int[] arr, ArrayList<Integer> list, int index, int sum) {
        if (index == arr.length) {
            if (sum == 2) {
                return 1;
            }
            return 0;
        }
        list.add(arr[index]);
        sum += arr[index];
        int l = countSubSequencesWithSumK(arr, list, index + 1, sum);

        list.remove(list.size() - 1);
        sum -= arr[index];
        int r = countSubSequencesWithSumK(arr, list, index + 1, sum);
        return l + r;
    }
}
