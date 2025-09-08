package basics.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//      Source, Intermediate Operations & Terminal

//      From Collection
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream = numbers.stream();
        long count = stream.filter(x -> x % 2 == 0).count();
        System.out.println("Count: " + count);

//      From Arrays
        String[] array = {"Prem", "Pinky"};
        Stream<String> arrayStream = Arrays.stream(array);

//      From Stream
        Stream<String> streamOf = Stream.of("Prem", "Pinky");

//      Infinite Stream
        Stream<Integer> generate = Stream.generate(() -> 1); // We can add limit to make it finite
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        System.out.println(iterate.limit(100).collect(Collectors.toList()));
    }
}
