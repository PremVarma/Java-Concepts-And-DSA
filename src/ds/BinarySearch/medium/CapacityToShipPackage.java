package ds.BinarySearch.medium;

public class CapacityToShipPackage {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println("Least day to ship: " + shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] arr, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : arr) {
            high += num;
            low = Math.max(low, num);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(arr, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean possible(int[] arr, int days, int weightCapacity) {
        int load = 0;
        int totalDays = 1;
        for (int num : arr) {
            if (load + num > weightCapacity) {
                load = num;
                totalDays += 1;
            } else {
                load += num;
            }
        }
        return totalDays <= days;
    }
}
