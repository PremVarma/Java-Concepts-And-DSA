package ds.Array.easy;

public class ReverseWords {
    public static void main(String[] args) {
        String[] arr = {"M", "Y", " ", "N", "A", "M", "E", " ", "I", "S", " ", "L", "O", "V", "E"};
        solution(arr);
    }

    private static void solution(String[] arr) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            temp.append(arr[i]);
            if (arr[i].equals(" ") || i == arr.length - 1) {
                temp.reverse();
                System.out.println(temp);
                temp = new StringBuilder();
            }
        }
    }
}
