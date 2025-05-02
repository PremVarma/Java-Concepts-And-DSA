package ds.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(findAllSubSet(list, list.size()));
        List<String> list2 = new ArrayList<>();
        list2.add("Jade");
        list2.add("John");
        list2.add("Apple");
        list2.add("Zebra");
        list2.add("Jabe");
        list2.add("Arch");
        list2.sort(null);
        System.out.println(list2);
    }

    private static List<List<Integer>> findAllSubSet(List<Integer> list, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        int subsets = 1 << n;
        for (int i = 0; i < subsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(list.get(j));
                }
            }
            answer.add(subset);
        }
        return answer;
    }
}
