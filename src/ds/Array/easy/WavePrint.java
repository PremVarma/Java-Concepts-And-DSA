package ds.Array.easy;

public class WavePrint {
    public static void main(String[] args) {
        int[][] arr = {{3, 4, 11},
                {2, 12, 1},
                {7, 8, 7}};
        solution(arr);
    }

    private static void solution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 1) { // Odd Index
                for (int j = arr.length - 1; j >= 0; j--) {
                    System.out.println(arr[i][j]);
                }
            } else {  // Even Index
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
