package org.example.C01_lean_basics.maths;

import java.util.ArrayList;
import java.util.Collections;

public class BasicMaths {
    public static void main(String[] args) {
        countOfDigits(7789);
        reverseDigits(7789);
        checkPalindrome(7871);
        armStrongNumber(371); // Qube of numbers and sum of numbers should equal to original num
        printAllDivisor(36);
        checkPrimeNo(7789);
        gcdOfTwoNumbers(10,15);
        gcdUsingEuclidean(10,15);
    }

    private static void gcdUsingEuclidean(int n1, int n2) {
        while(n1>0 && n2>0){
             if(n1>n2) n1 = n1%n2;
             else n2 = n2 % n1;
        }
        if(n1==0) System.out.println(n2);
        else System.out.println(n1);
    }

    private static void gcdOfTwoNumbers(int n1, int n2) {
        int gcd = 1;
        for (int i = Math.min(n1,n2); i>=1; i--) {
            if(n1%i==0 && n2%i==0){
                gcd = i;
                break;
            }
        }
        System.out.println(gcd);
    }

    private static void checkPrimeNo(int n) {
        int counter = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                counter++;
            }
        }
        if(counter>=1){
            System.out.println(n+" Not Prime Number");
        }else{
            System.out.println(n+" Prime Number");
        }
    }

    private static void printAllDivisor(int n) {
        ArrayList list = new ArrayList();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                list.add(i);
                if(n/i!=i){
                    list.add(n/i);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }

    private static void armStrongNumber(int n) {
        int sum = 0;
        int dup = n;
        while(n>0){
            int lastDigit = n%10;
            sum += lastDigit*lastDigit*lastDigit;
            n = n/10;
        }
        if(dup == sum){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    private static boolean checkPalindrome(int n) {
        int rev = 0;
        int dup = n;
        while(n>0){
            int lastDigit = n%10;
            rev = (rev *10)+lastDigit;
            n = n / 10;
        }
        if(rev==dup){
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    private static void reverseDigits(int n) {
        int rev = 0;
        while(n>0){
            int lastDigit = n%10;
            rev = (rev *10)+lastDigit;
            n = n / 10;
        }
        System.out.println(rev);
    }

    private static void countOfDigits(int n) {
        int count = 0;
        // shortcut => (int) log10(n)+1 will return no digits inside number
        while(n>0){
            count = count+1;
            n = n/10;
        }
        System.out.println(count);
    }
}
