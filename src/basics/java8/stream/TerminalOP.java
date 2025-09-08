package basics.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOP {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//      Collect
        list.stream().skip(1).collect(Collectors.toList());

//      ForEach
        list.stream().forEach(x -> System.out.println(x));

//      Reduce
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println(reduce.get());

//      Peek
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

//      ToArray
        Object[] array = Stream.of(1, 2, 3).toArray();

//      min/max
        System.out.println("Max: " + Stream.of(2, 44, 69).max((a, b) -> b - 1));
        System.out.println("Min: " + Stream.of(2, 44, 69).min(Comparator.naturalOrder()));

//      flatMap
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("Apple", "Banana"), Arrays.asList("Orange", "Grapes"));
        List<String> fruits = listOfLists.stream().flatMap(x -> x.stream().map(String::toUpperCase)).toList();
        System.out.println(fruits);

//      AnyMatch, ALlMatch, NoneMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
        boolean allMatch = list.stream().allMatch(x -> x > 0);
        System.out.println(allMatch);
        boolean noneMatch = list.stream().noneMatch(x -> x < 0);
        System.out.println(noneMatch);
//      findFirst, findAny
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first.get());
        Optional<Integer> any = list.stream().findAny();
        System.out.println(any.get());

        String sentence = "Hello World";
        long count = Arrays.stream(sentence.split("")).filter(x -> x.equalsIgnoreCase("l")).count();
        System.out.println(count);
    }
}
