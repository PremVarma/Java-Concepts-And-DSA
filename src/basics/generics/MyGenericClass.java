package basics.generics;

public class MyGenericClass<T> {
    private T value;

    public MyGenericClass(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }
}
