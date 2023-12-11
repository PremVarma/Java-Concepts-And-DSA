package systemdesign.designpattern.creation.singleton;

public class Singleton {
    private static Singleton instance;
    int value = 0;

    private Singleton() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
