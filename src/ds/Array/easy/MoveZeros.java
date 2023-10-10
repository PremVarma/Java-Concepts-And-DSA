package ds.Array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1};
        solution(arr);
    }

    private static void solution(int[] arr) {
        int start = 0, ahead = start;
        while (ahead < arr.length) {
            if (arr[ahead] != 0) {
                int temp = arr[start];
                arr[start] = arr[ahead];
                arr[ahead] = temp;
                start++;
            }
            ahead++;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void optimalSolution(int[] arr) {
        int i = -1;
        for (int j = 1; j < arr.length; j++) {
            if(arr[j]==0){
                i=j;
                break;
            }
        }

        for (int j = i+1; j < arr.length; j++) {
            if(arr[j]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    private static void bruteForce(int[] arr) {
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                list.add(arr[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        for (int i = list.size(); i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

}
