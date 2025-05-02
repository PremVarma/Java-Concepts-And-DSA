package basics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 1);
        list.sort(new MyComparator());
        System.out.println(list);

//      Sort based on lenght of String
        List<String> words = Arrays.asList("Apple", "Banana", "Pear", "Leaf", "Chi");
//        words.sort(new StringLengthComparator());
        System.out.println(words);

//        words.sort((a,b) -> a.length() - b.length());
        Comparator<String> comparing = Comparator.comparing(String::length); // thenComparing
        words.sort(comparing);
        System.out.println(words);
    }
}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

}
