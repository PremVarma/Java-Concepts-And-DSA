package ds.BinarySearch.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PainterPartitionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(48,90));
        int k = 2;
        int largestMinDistance = findLargestMinDistance(list, k);
        System.out.println(largestMinDistance);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = list1;
        list2.add(3);
        System.out.println(list1);
        System.out.println(list2);

    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = boards.stream().mapToInt(Integer::intValue).max().orElse(0), high = boards.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(boards, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean possible(ArrayList<Integer> boards, int k, int paintUnit) {
        if (boards.size() < k) return false;
        int painters = 1;
        int units = 0;
        for (int unit : boards) {
            if (units + unit <= paintUnit) {
                units += unit;
            } else {
                painters += 1;
                units = unit;
            }
        }
        return painters <= k;
    }
}
