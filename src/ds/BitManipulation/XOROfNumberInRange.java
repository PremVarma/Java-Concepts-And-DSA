package ds.BitManipulation;

public class XOROfNumberInRange {
    public static void main(String[] args) {
//      for example if n=4, 1^2^3^4
        System.out.println(xor(5));
    }

    private static int xor(int n) {
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else if (n % 4 == 3) return 0;
        else return n;
    }
}
