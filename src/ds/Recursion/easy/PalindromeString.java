package ds.Recursion.easy;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "Aka";
        System.out.println(isPalindrome(str, 0, str.length()));
    }

    private static boolean isPalindrome(String str, int l, int r) {
        if (l >= r / 2) {
            return true;
        }
        if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r - l - 1))) {
            return false;
        }
        return isPalindrome(str, l + 1, r);
    }

}
