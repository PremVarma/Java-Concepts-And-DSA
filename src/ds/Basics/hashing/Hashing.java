package org.example.C01_lean_basics.hashing;

import java.util.Arrays;
import java.util.HashMap;

// Prestoring and fetching
// Hashmap is unordered map -> insertion and lookup is 0(1) for best and average , worst o(n) very very rare because of collision when all key apper on same hash index
// LinkedHashMap is ordered map -> maintain order
public class Hashing {
    public static void main(String[] args) {
        int num[] = {1,3,2,1,3};
        getCharsCountInStringForaToz();
        getCharsCountInStringForAllChar();
        getIntCountUsingHashmap();
        findHighestAndLowestFreqElement();
    }

    private static void findHighestAndLowestFreqElement() {
        int a[] = {1,12,4,6,12,12,4,5,12};
        HashMap<Integer,Integer> hashMap =  new HashMap();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            hashMap.put(a[i],hashMap.getOrDefault(a[i],0)+1);
            max = Math.max(max,hashMap.get(a[i]));
            min = Math.min(min,hashMap.get(a[i]));
        }
        System.out.println(hashMap+"\nmax: "+max+"\nmin: "+min);
    }

    private static void getIntCountUsingHashmap() {
        int a[] = {1,12,4,6,12,12,4,5};
        HashMap<Integer,Integer> hashMap =  new HashMap();
        for (int i = 0; i < a.length; i++) {
            hashMap.put(a[i],hashMap.getOrDefault(a[i],0)+1);
        }
        System.out.println(hashMap);
    }

    private static void getCharsCountInStringForAllChar() {
        String s = "abcdabehfAAB@";
        int hash[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int charAt =  s.charAt(i);
            hash[charAt]++;
        }
        System.out.println(Arrays.toString(hash));
    }

    private static void getCharsCountInStringForaToz() {
        String s = "abcdabehf";
        int hash[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int charAt =  s.charAt(i)- 'a'; // a starts with 97 but out array starts with 0 so any character -a will start from 0 to 26 max
            // example 'a' - 'a' -> 0 'b'-'a'->2
            hash[charAt]++;
        }
        System.out.println(Arrays.toString(hash));
    }
}
