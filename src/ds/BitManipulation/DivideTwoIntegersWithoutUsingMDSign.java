package ds.BitManipulation;

public class DivideTwoIntegersWithoutUsingMDSign {
    public static void main(String[] args) {
        int dividend = 214748364;
        int divisor = -2888;
        System.out.println(divideTwoIntegers(dividend, divisor));
    }

//  3 * 2^0   3 * 2^1   3*2^2  3*2^3

    private static int divideTwoIntegers(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        boolean sign = true;
        if (dividend >= 0 && divisor < 0) sign = false;
        if (dividend < 0 && divisor > 0) sign = false;
        long ans = 0;
        int n = Math.abs(dividend), d = Math.abs(divisor);
        while (n >= d) {
            int counter = 0;
            while (n >= (d << counter + 1)) {
                counter += 1;
            }
            ans += (1L << counter); // 2 ^ counter;
            n = n - (d << counter);  // n - (d * (1 << counter));
        }
        if (ans >= (2 ^ 31) && sign) {
            return Integer.MAX_VALUE;
        }
        if (ans >= (2 ^ 31) && !sign) {
            return Integer.MIN_VALUE;
        }
        return (int) (sign ? ans : -ans);
    }
}
