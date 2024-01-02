package basics.generics;

public class BoundedGenerics {
    public static void main(String[] args) {
        Print<Integer> print = new Print<>();
        print.setValue(10);
        System.out.println(print.getValue());

        System.out.println("Multi Bound");
        PrintMultiBound<MyClassUseParent> printMultiBound = new PrintMultiBound<>(); // Should extend and implement all interface which we defined

    }
}

//=============== UPPER BOUND ===================
class Print<T extends Number> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

//================MULTI BOUND========================
class ParentClass {
}

interface Interface1 {
}

interface Interface2 {
}

class PrintMultiBound<T extends ParentClass & Interface1 & Interface2> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class MyClassUseParent extends ParentClass implements Interface1,Interface2{}
class MyClassUseInterface extends ParentClass implements Interface1{}


