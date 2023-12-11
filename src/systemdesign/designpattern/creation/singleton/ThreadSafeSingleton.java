package systemdesign.designpattern.creation.singleton;


import java.io.Serializable;

public class ThreadSafeSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation from outside.
    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Implement readResolve to control deserialization
    protected Object readResolve() {
        return getInstance();
    }

}
