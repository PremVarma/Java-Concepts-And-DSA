package basics.java8;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        MathOperation sum = (a, b) -> a + b;
        MathOperation substract = (a, b) -> a - b;
        System.out.println(sum.operate(1, 2));
    }
}

interface MathOperation {
    int operate(int a, int b);
}