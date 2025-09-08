package basics.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {
//      Method Reference
        List<String> list = Arrays.asList("Prem", "Pinky", "Neha", "Abhijit");
        list.forEach((x) -> System.out.println(x));
//      Method reference
        list.forEach(System.out::println);
//      Constructor reference
        List<Name> collect = list.stream().map(Name::new).collect(Collectors.toList());
        System.out.println(collect);
    }
}

class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}
