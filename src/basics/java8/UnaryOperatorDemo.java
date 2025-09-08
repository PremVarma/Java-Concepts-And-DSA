package basics.java8;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> a = x -> 2 * x; // when input and output is same
        System.out.println(a.apply(5));
        BinaryOperator<Integer> b = (x, y) -> x + y;
        System.out.println(b.apply(10,11));
    }
}
