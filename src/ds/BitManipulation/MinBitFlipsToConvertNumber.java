package ds.BitManipulation;

public class MinBitFlipsToConvertNumber {
    public static void main(String[] args) {
        int start = 10, end = 10;
        System.out.println(minBitRequired(start, end));
    }

    private static int minBitRequired(int start, int end) {
        int ans = start ^ end;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((ans & (1 << i)) == 1) {
                count++;
            }
        }
        return count;
    }
}
