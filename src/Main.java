import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        BigDecimal bigDecimal = new BigDecimal(100);
//        System.out.println(bigDecimal.toString());
//        MyClass myClass = new MyClass();
//        myClass.setLine1(bigDecimal.toString());
//        System.out.println("Hello");
//        System.out.println(atoi("123P"));

        int a = 1;
        int b = 2;
        switch (a + b) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
            case 4:
                System.out.println("4");
            default:
                System.out.println("default");
        }
    }



    private static int atoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.trim();
        char firstChar = s.charAt(0);
        if (!isValidFirstChar(firstChar)) {
            return 0;
        }
        int result = 0;
        boolean isNegative = (firstChar == '-');
        int i = (firstChar == '+' || firstChar == '-') ? 1 : 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = Character.getNumericValue(s.charAt(i));
            if (isOverflow(result, digit)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result;
    }

    private static boolean isOverflow(int result, int digit) {
        return result > (Integer.MIN_VALUE - digit) / 10;
    }

    private static boolean isValidFirstChar(char firstChar) {
        return (firstChar == '+' || firstChar == '-' || Character.isDigit(firstChar));
    }

    public static Node flattern(Node head) {
        if (head == null) {
            return null;
        }
        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
        }
        Node curr = head;
        while (curr != tmp) {
            if (curr.child != null) {
                tmp.next = curr.child;
                Node temp = curr.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                tmp = temp;
            }
            curr = curr.next;
        }
        return head;
    }
}

class MyClass {
    private String line1;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }
}

class Node {
    int data;
    Node next;
    Node child;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}
