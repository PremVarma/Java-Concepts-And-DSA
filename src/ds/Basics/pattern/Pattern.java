package org.example.C01_lean_basics.pattern;

public class Pattern {
    public static void main(String[] args) {
        System.out.println("Patterns");
//        **
//        **
        Pattern1(2);
//        *
//        **
//        ***
        Pattern2(3);
//        1
//        12
//        123
        Pattern3(3);
//        1
//        22
//        333
        Pattern4(3);
//        ***
//        **
//        *
        Pattern5(3);
//          *
//        * * *
//      * * * * *
        Pattern6(5);
        Pattern7(5);
//        *
//        **
//        ***
//        **
//        *
        Pattern8(5);
        Pattern9(5);
        Pattern10(5);
        Pattern11(5);
        Pattern12(5);
        Pattern13(5);
        Pattern14(5);
        Pattern15(4);
        Pattern16(4);
    }

    private static void Pattern16(int n) {
        int count = n;
        for (int i = 0; i < 2*n-1; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                int top = i;
                int left = j;
                int right = (2*n-2)-j;
                int bottom = (2*n-2)-i;
                System.out.printf(String.valueOf(n- Math.min(Math.min(top,bottom),Math.min(left,right))));
            }
            System.out.println();
        }
    }

    private static void Pattern15(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 || i==n-1 || j==0 || j==n-1){
                    System.out.printf("*");
                }else{
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }

    private static void Pattern14(int n) {
        int spaces = 2*n-2;
        for (int i = 1; i <= 2*n-1; i++) {
            int stars = i<n ? i :2*n-i;
            for (int j = 1; j <= stars ; j++) {
                System.out.printf("*");
            }
            for (int j = 1; j <= spaces ; j++) {
                System.out.printf(" ");
            }
            for (int j = 1; j <= stars ; j++) {
                System.out.printf("*");
            }
            System.out.println();
            spaces = i<n ? spaces-2 : spaces+2;
        }
    }

    private static void Pattern13(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-i ; j++) {
                System.out.printf("*");
            }
            for (int j = 0; j <2*i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <n-i ; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.printf("*");
            }
            for (int j = 0; j <2*(n-i)-2 ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i ; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    private static void Pattern12(int n) {
        char initial = (char) ('A'+ (n-1));
        for (int i = 0; i < n; i++) {
            for (char c = (char) (initial - i); c <= initial; c++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void Pattern11(int n) {
        for (int i = 0; i < n; i++) {
            char first = 65;
            for (int j = 0; j <= i ; j++) {
                System.out.print(first);
                first+=1;
            }
            System.out.println();
        }
    }

    public static void Pattern1(int n){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Pattern2(int n){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Pattern3(int n){
        for (int i = 0; i <= n ; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void Pattern4(int n){
        for (int i = 0; i <= n ; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void Pattern5(int n){
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j <=n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Pattern6(int n){
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n-i-1; j++) { // i
                System.out.print(" ");
            }
            for (int j = 0; j <2*i+1 ; j++) { // 2*(n-i)-1
                System.out.print("*");
            }
            for (int j = 0; j < n-i-1; j++) { // i
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void Pattern7(int n){
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i; j++) { // i
                System.out.print(" ");
            }
            for (int j = 0; j < 2*(n-i)-1 ; j++) { // 2*(n-i)-1
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) { // i
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void Pattern8(int n){
        for (int i = 1; i <= 2*n-1 ; i++) {
            int stars = i<n ? i : 2*n-i;
            for (int j = 1; j <= stars ; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }

    }

    public static void Pattern9(int n){
        for (int i = 0; i <n ; i++) {
            int start = i%2==0 ? 1 :0;
            for (int j = 0; j <=i ; j++) {
                System.out.printf(String.valueOf(start));
                start = 1-start;
            }
            System.out.println();
        }
    }

    public static void Pattern10(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            for (int j = 0; j < (2*(n-i+1))-2; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >=1 ; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
