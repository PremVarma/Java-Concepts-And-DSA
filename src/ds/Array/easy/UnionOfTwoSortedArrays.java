package ds.Array.easy;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfTwoSortedArrays {
    public static void main(String args[]) {
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union = solution(arr1, arr2, n, m);
        ArrayList<Integer> UnionII = solutionII(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : Union)
            System.out.print(val + " ");
    }

    private static ArrayList<Integer> solutionII(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer > result=new ArrayList<>();
        while (i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                if(result.isEmpty() || result.get(result.size()-1)!=arr1[i]){
                    result.add(arr1[i]);
                }
                i++;
            }else{
                if(result.isEmpty() || result.get(result.size()-1)!=arr2[j]){
                    result.add(arr2[j]);
                }
                j++;
            }
        }

        while(i<arr1.length){
            if(result.isEmpty() || result.get(result.size()-1)!=arr1[i]){
                result.add(arr1[i]);
            }
            i++;
        }

        while(j<arr2.length){
            if(result.isEmpty() || result.get(result.size()-1)!=arr2[j]){
                result.add(arr2[j]);
            }
            j++;
        }
        return result;
    }

    private static ArrayList<Integer> solution(int[] arr1, int[] arr2, int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return new ArrayList<>(set);
    }
}
