package ds.String.easy;

public class ImplementationOfAtoi {

    public static void main(String[] args) {
        // Examples
        System.out.println(atoi("42")); // Output: 42
        System.out.println(atoi("   -42")); // Output: -42
        System.out.println(atoi("4193 with words")); // Output: 4193
        System.out.println(atoi("words and 987")); // Output: 0
        System.out.println(atoi("-91283472332")); // Output: -2147483648 (Integer.MIN_VALUE)
    }
    public static int atoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0; // Empty or null string, return 0
        }

        // Trim leading and trailing whitespaces
        str = str.trim();

        char firstChar = str.charAt(0);
        if (!isValidFirstChar(firstChar)) {
            return 0; // Invalid first character
        }

        boolean isNegative = (firstChar == '-');
        int result = 0;
        int i = (firstChar == '+' || firstChar == '-') ? 1 : 0;

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));

            // Check for overflow before updating the result
            if (isOverflow(result, digit)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return isNegative ? -result : result;
    }

    private static boolean isValidFirstChar(char firstChar) {
        return (firstChar == '+' || firstChar == '-' || Character.isDigit(firstChar));
    }

    private static boolean isOverflow(int result, int digit) {
        // Check for integer overflow
        return result > (Integer.MAX_VALUE - digit) / 10;
    }
}
