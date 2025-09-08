package ds.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(findAllSubSet(list, list.size()));
    }

    private static List<List<Integer>> findAllSubSet(List<Integer> list, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        int subsets = 1 << n;
        for (int i = 0; i < subsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // bit is set or not
                    subset.add(list.get(j));
                }
            }
            answer.add(subset);
        }
        return answer;
    }
}
