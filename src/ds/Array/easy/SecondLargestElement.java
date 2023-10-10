package ds.Array.easy;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 4, 6, 7, 5};
        int n = arr.length;
        solutionII(arr, n);
    }

    private static void solution(int[] arr, int n) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        for (int num : arr) {
            if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        System.out.println(secondMax);
    }

    private static void solutionII(int[] arr, int n) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        System.out.println(secondMax);
    }
}
