package ds.Recursion.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthPermutation {
    public static void main(String[] args) {
        int n = 4, k = 17;
        String ans = getPermutationOP(n, k);
        System.out.println("The Kth permutation sequence is " + ans);
    }

    static void swap(char s[], int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }

    static void permutationHelper(char s[], int index, ArrayList<String> res) {
        if (index == s.length) {
            String str = new String(s);
            res.add(str);
            return;
        }
        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            permutationHelper(s, index + 1, res);
            swap(s, i, index);
        }
    }

    static String getPermutationBF(int n, int k) {
        StringBuilder s = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        permutationHelper(s.toString().toCharArray(), 0, res);
        Collections.sort(res);

        return res.get(k);

    }

    static String getPermutationOP(int n, int k) {
        int fact = 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            res.add(i);
        }
        res.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1; // o based indexing
        while (true) {
            ans.append(res.get(k / fact));
            res.remove(k / fact);
            if (res.isEmpty()) break;
            k = k % fact;
            fact = fact / res.size();
        }
        return ans.toString();
    }
}
