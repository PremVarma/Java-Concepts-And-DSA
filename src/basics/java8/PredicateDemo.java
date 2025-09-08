package basics.java8;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.test(3));
        Predicate<String> isWordStartsWithP = x -> x.toLowerCase().startsWith("p");
        Predicate<String> isWordEndsWithM = x -> x.toLowerCase().endsWith("m");
        Predicate<String> and =  isWordStartsWithP.and(isWordEndsWithM);
        System.out.println(and.test("Prem"));
    }
}
