package basics.java8;

public class LambaExpressionDemo {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("Thread using lambda expression");
        });
        t.start();
    }
}
