package basics.exception;

public class StackTraceExample {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        int result = 10 / 0; // This line will throw an ArithmeticException
    }

    public static void method3() throws CustomEx {
        throw new CustomEx("This is custom exception");
    }
}

class CustomEx extends Exception{

    public CustomEx(String thisIsCustomException) {
        super(thisIsCustomException);
    }
}
