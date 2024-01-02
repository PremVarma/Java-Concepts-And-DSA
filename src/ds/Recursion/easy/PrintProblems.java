package ds.Recursion.easy;

public class PrintProblems {
    public static void main(String[] args) {
        System.out.println("Print Name N times");
        printName(1, 5);
        System.out.println("Print from 1 to N");
        printFrom1ToN(1, 10);
        System.out.println();
        System.out.println("Print from N to 1");
        printFromNTo1(10, 10);
        System.out.println();
        System.out.println("Print from 1 to N using BK");
        printFrom1ToNBackTrack(10, 10);
        System.out.println();
        System.out.println("Print from N to 1 using BK");
        printFromNTo1BackTrack(1, 10);

    }

    private static void printFromNTo1BackTrack(int i, int N) {
        if(i>N) return;
        printFromNTo1BackTrack(i+1,N);
        System.out.print(i+", ");
    }

    private static void printFrom1ToNBackTrack(int i, int N) {
        if (i < 1) return;
        printFrom1ToNBackTrack(i - 1, N);
        System.out.print(i + ", ");
    }

    private static void printFromNTo1(int i, int N) {
        if (i < 1) return;
        System.out.print(i + ", ");
        printFromNTo1(i - 1, N);
    }

    private static void printFrom1ToN(int i, int N) {
        if (i > N) return;
        System.out.print(i + ", ");
        printFrom1ToN(i + 1, N);
    }

    private static void printName(int i, int count) {
        if (i > count) return;
        System.out.println("Prem Varma");
        printName(i + 1, count);
    }
}
