public class PowerExponential {
    public static void main(String[] args) {
        func(4, 20);
    }

    public static long func(int b, int exp) {
        long ans = 1;
        long base = b;

        while (exp > 0) {
            if (exp % 2 == 1) {
                // If the current exponent is odd, multiply ans by base
                exp--;
                ans = ans * base;
            } else {
                // If the current exponent is even, square the base
                exp /= 2;
                base = base * base;
            }
        }

        return ans;
    }
}
