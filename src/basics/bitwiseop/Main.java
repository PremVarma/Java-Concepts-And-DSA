package basics.bitwiseop;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
        System.out.println("AND OP");
        System.out.println(5 & 7);

        System.out.println("OR OP");
        System.out.println(5 | 7);

        System.out.println("XOR OP");
        System.out.println(5 ^ 7);

        System.out.println("NOT OP");
        System.out.println(~5);

        System.out.println("LEFT SHIFT");
        System.out.println(5 << 1);

        System.out.println("RIGHT SHIFT");
        System.out.println(5 >> 1);

        System.out.println("UNSIGNED RIGHT SHIFT");
        System.out.println(10 >>> 1);

        System.out.println("Prem".equalsIgnoreCase("prem"));
    }
}
