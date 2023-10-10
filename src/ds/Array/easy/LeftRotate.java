package ds.Array.easy;

public class LeftRotate {
    public static void main(String args[]) {
        int n = 7;
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;
        solution(arr, n, k);
        solutionII(arr, n, k);
        System.out.println("After Rotating the elements to left ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void solution(int[] arr, int n, int k) {
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i-(n-k)];
        }
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    // Function to Rotate k elements to left
    public static void solutionII(int[] arr, int n, int k) {
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse last n-k elements
        reverse(arr, k , n - 1);
        // Reverse whole array
        reverse(arr, 0, n - 1);
    }
}
