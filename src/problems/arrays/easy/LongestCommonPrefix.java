package problems.arrays.easy;

// https://leetcode.com/problems/longest-common-prefix/description/?envType=problem-list-v2&envId=array
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String base = strs[0];

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < base.length()) {
                base = strs[i];
            }
        }

        for (int i = 0; i < base.length(); i++) {
            boolean notMatching = false;
            for (int j = 1; j < strs.length; j++) {
                if (base.charAt(i) != strs[j].charAt(i)) {
                    notMatching = true;
                    break;
                }
            }

            if (notMatching) {
                break;
            }
            prefix.append(base.charAt(i));
        }

        return prefix.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
