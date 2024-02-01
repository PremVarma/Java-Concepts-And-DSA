package ds.BinarySearch.easy;

public class FIndNthRootOfNum {
    public static void main(String[] args) {
        int n = 4, m = 107;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }

    private static int NthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = (int) calculateNthRoot(mid, n);
            if (value == m) {
                return mid;
            } else if (value < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int func(int mid, int n, int m) { // Use this to avoid very long number stop as soon as we pass to number
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    //    Power Exponential
    private static long calculateNthRoot(int num, int exp) {
        long ans = 1;
        long base = num;
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans = ans * base;
            } else {
                exp /= 2;
                base = base * base;
            }
        }
        return ans;
    }
}
