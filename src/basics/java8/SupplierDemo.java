package basics.java8;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> greet = () -> "Hello World";
        System.out.println(greet.get());
    }
}
