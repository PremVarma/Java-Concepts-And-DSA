package basics.generics;

public class Person<T> {
    private T name;

    public Person(T value) {
        this.name = value;
    }

    public T getValue() {
        return name;
    }

    public void setValue(T name) {
        this.name = name;
    }
}

