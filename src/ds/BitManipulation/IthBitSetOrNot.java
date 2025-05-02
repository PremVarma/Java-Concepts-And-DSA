package ds.BitManipulation;

public class IthBitSetOrNot {
    public static void main(String[] args) {
        int num = 13, i = 2;

        System.out.println("Bit set: " + findIfIthBitSet(num, i));
        System.out.println("Set set: " + setIthBit(9, i));
        System.out.println("Clear set: " + clearIthBit(num, i));
        System.out.println("Toggle bit: " + toggleIthBit(num, i));
        System.out.println("Remove the set bit (Rightmost) : " + removeSetBit(num));
        System.out.println("Check if num is power of 2 : " + checkPowerOf2(5));
        System.out.println("Count num of set bits : " + countSetBit(num));
    }

    private static int countSetBit(int num) {
        int count = 0;
        while (num > 1) {
            count += num & 1;
            num >>= 1;
        }
        if (num == 1) count += 1;
        return count;
    }


    private static int countSetBitBetter(int num) {
        int count = 0;
        while (num > 1) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    private static boolean checkPowerOf2(int num) {
        return ((num & num - 1) == 0);
    }

    private static int removeSetBit(int num) {
        return (num & (num - 1));
    }

    private static int toggleIthBit(int num, int i) {
        return (num ^ (1 << i));
    }

    private static int clearIthBit(int num, int i) {
        return (num & ~(1 << i));
    }

    private static int setIthBit(int num, int i) {
        return (num | (1 << i));
    }

    private static boolean findIfIthBitSet(int num, int i) {
        return ((num & (1 << i)) != 0);
    }
}
