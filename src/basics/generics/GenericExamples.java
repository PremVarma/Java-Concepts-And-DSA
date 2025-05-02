package basics.generics;

// T - Type
// E - Element (used in collections )
// K- Key (used in map )
// V- value ( used in map)
// N - number
//S, U, R, etc.	Additional Type Parameters	When you need multiple types (e.g., in utility classes or methods)

import java.util.ArrayList;

// Basic Generic
class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

// Basic Generic P2

class PairGeneric<K, V> {
    private K key;
    private V value;

    public PairGeneric(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// Generic Interface
interface Container<T> {
    void add(T item);

    T get();
}

class StringContainer implements Container<String> {

    @Override
    public void add(String item) {

    }

    @Override
    public String get() {
        return "";
    }
}


// Bounded Type Parameters
class BoundedBox<T extends Number> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}


// Generic in Constructors
class Box2 {
    public <T> Box2(T item) {
        // without making class generic we just made constructor generic
    }
}

public class GenericExamples {
    public static void main(String[] args) {
//        Basic Generic
        Box<Integer> intBox = new Box<>();
        intBox.setValue(10);
        System.out.println(intBox.getValue());
//       Bounded
        BoundedBox<Integer> boundedBox = new BoundedBox<>();
        System.out.println(boundedBox.getValue());
    }

    //    Generic Methods
    public <T> void methodName(T parameter) {

    }

    public static <T> T getData(ArrayList<T> list) {
        return list.get(0);
    }
}
