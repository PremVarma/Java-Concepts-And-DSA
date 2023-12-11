import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(100);
        System.out.println(bigDecimal.toString());
        MyClass myClass =  new MyClass();
        myClass.setLine1(bigDecimal.toString());
        System.out.println("Hello");
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

class MyClass{
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
