package org.example.C01_lean_basics.recursion;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        printName(1,5);
        print1ToNNumber(1,3);
        printNTo1Number(3,3);
        print1ToNNumberBackTracking(3,3);
        print1Nto1umberBackTracking(1,3);
        sumOfFirstNNumber(10,0);
        System.out.println(sumOfFirstNNumberFunctional(10));
        System.out.println(factorialOfNNumber(4));
        reverseArrayTwoPointer(new int[]{1,2,3,4,5},0,4);
        System.out.println(fibonicci(4));
    }

    private static int fibonicci(int i) {
        if(i<=1){
            return i;
        }
        return fibonicci(i-1)+ fibonicci(i-2);
    }

    private static void reverseArrayTwoPointer(int[] nums,int i,int j) {
        if(i>=j){
            System.out.println(Arrays.toString(nums));
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        reverseArrayTwoPointer(nums,i+1,j-1);
    }

    private static int factorialOfNNumber(int i) {
        if(i==0){
            return 1;
        }
        return i*factorialOfNNumber(i-1);
    }

    private static int sumOfFirstNNumberFunctional(int i) {
        if(i==0){
            return 0;
        }
        return i+sumOfFirstNNumberFunctional(i-1);
    }

    private static void sumOfFirstNNumber(int n,int sum) {
        if(n<1){
            System.out.println(sum);
            return;
        }
        sumOfFirstNNumber(n-1,sum+n);
    }

    private static void print1Nto1umberBackTracking(int i, int n) {
        if(i>n){
            return;
        }
        print1Nto1umberBackTracking(i+1,n);
        System.out.println(i);
    }

    private static void print1ToNNumberBackTracking(int i, int n) {
        if(i<1){
            return;
        }
        print1ToNNumberBackTracking(i-1,n);
        System.out.println(i);
    }

    private static void printNTo1Number(int i, int n) {
        if(i<1){
            return;
        }
        System.out.println(i);
        printNTo1Number(i-1,n);
    }

    private static void print1ToNNumber(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println(i);
        print1ToNNumber(i+1,n);
    }

    private static void printName(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println("Prem");
        printName(i+1,n);
    }
}
