package ds.Stack;

public class RainTrappingProblem {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,2,0,1,3,1,2,0,1,2};
        int total = findTotalWater(arr);
        System.out.printf("total water : " + total);
    }

    private static int findTotalWater(int[] arr) {
        int lmax = 0, rmax = 0, total = 0;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] <= arr[r]) {
                if (lmax > arr[l]) {
                    total += lmax - arr[l];
                } else {
                    lmax = arr[l];
                }
                l = l + 1;
            } else {
                if (rmax > arr[r]) {
                    total += rmax - arr[r];
                } else {
                    rmax = arr[r];
                }
                r = r - 1;
            }
        }
        return total;
    }
}
