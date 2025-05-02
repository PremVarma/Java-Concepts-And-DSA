package ds.BitManipulation;

public class NumberConversion {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(13));
        System.out.println(binaryToDecimal("1101"));
    }

    public static String decimalToBinary(int number) {
        if (number == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.append(number % 2);
            number /= 2;
        }
        return result.reverse().toString();
    }

    public static int binaryToDecimal(String number) {
        int result = 0, p2 = 1;
        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) == '1') {
                result += p2;
            }
            p2 *= 2;
        }
        return result;
    }

    public static int binaryToDecimalL2R(String number) {
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            // Convert the character to its numeric value ('0' -> 0, '1' -> 1)
            int digit = number.charAt(i) - '0';
            // Multiply the current result by 2 and add the current digit
            result = result * 2 + digit;
        }
        return result;
    }
}
