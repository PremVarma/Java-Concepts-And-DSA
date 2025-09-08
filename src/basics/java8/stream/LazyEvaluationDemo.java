package basics.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Prem", "Pinky");
        Stream<String> stringStream = list.stream().filter(x -> {
            System.out.println("Inside Filter OP");
            return x.length() > 3;
        });

        System.out.println("Before Terminal OP");

        List<String> collect = stringStream.collect(Collectors.toList());
        System.out.println("After Terminal OP"+ collect);
    }
}
