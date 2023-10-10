package ds.Array.easy;

public class ArraySortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(solution(arr));
    }

    private static boolean solution(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                count++;
            }
        }

        if (arr[arr.length - 1] > arr[0]) {
            count++;
        }

        return count<=1;
    }
}
