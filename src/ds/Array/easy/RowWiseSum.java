package ds.Array.easy;

public class RowWiseSum {
    public static void main(String[] args) {
        int[][] arr = {{3, 4, 11}, {2, 12, 1}, {7, 8, 7}};
        solution(arr);
    }
    private static void solution(int[][] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum+=arr[i][j];
            }
            if(largest<sum){
                largest = sum;
            }
        }
        System.out.println(largest);
    }
}
