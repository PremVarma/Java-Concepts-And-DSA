package ds.Recursion.easy;

public class SumOfFirstNNums {
    public static void main(String[] args) {
        int sum = sumOfNNums(3, 0);
        System.out.println(sumOfNNums2(5));
    }

    private static int sumOfNNums(int n, int sum) {
        if (n < 1) {
            System.out.println("Sum of first" + n + " => " + sum);
            return sum;
        }
        return sumOfNNums(n - 1, sum + n);
    }

    private static int sumOfNNums2(int n) {
        if (n < 1) {
            return 0;
        }
        return n + sumOfNNums2(n - 1);
    }
}
