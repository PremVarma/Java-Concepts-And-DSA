package ds.Array.easy;

public class MaximumConsecutiveOnes {
    public static void main(String args[]) {
        int nums[] = {1, 1, 0, 1, 1, 1};
        int ans = solution(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }

    private static int solution(int[] arr) {
        int max = 0, count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
