package basics.java8.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie");
        list.stream().filter(x -> x.startsWith("A"))
                .collect(Collectors.toList());

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> set = numbers.stream().collect(Collectors.toSet());

        ArrayDeque<String> collect = list.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        String collectingString = list.stream().map(String::toUpperCase).collect(Collectors.joining());

        IntSummaryStatistics collect1 = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(collect1);

        List<String> list2 = Arrays.asList("hello", "world", "java", "streams", "prem");
        Map<Integer, List<String>> collect2 = list2.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect2);
        Map<Integer, String> collect3 = list2.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
        System.out.println(collect3);
        Map<Integer, Long> collect4 = list2.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collect4);
        TreeMap<Integer, Long> collect5 = list2.stream().collect(Collectors.groupingBy(String::length,TreeMap::new, Collectors.counting()));
        System.out.println(collect5);



//      Partitioning elements
        System.out.println(list2.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

//      Mapping and Collection
        System.out.println(list2.stream().collect(Collectors.mapping(x -> x.toUpperCase(),Collectors.toList())));
    }
}
