package basics.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOP {
    public static void main(String[] args) {
//      Intermediate op  transform a stream into another stream and they are lazy  and not execute until you apply terminal opeartion
        List<String> list = Arrays.asList("Prem", "Akshat", "Utkarsh", "Sanath", "Aarav", "Pinky");
        Stream<String> stringStream = list.stream().filter((x) -> x.startsWith("A"));
//      No filtering until now
        long count = list.stream().filter((x) -> x.startsWith("P")).count();
        System.out.println(count);


    }
}
