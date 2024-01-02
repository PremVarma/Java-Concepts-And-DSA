package basics.generics.wildcard;

interface MyInterface {
}

class MyClass implements MyInterface {
}

class BoundedClassExampleAgain<T extends MyInterface> {
    public void printClassName(Class<? extends T> clazz) {
        System.out.println("Class Name: " + clazz.getName());
    }

    public static void main(String[] args) {
        // Valid usage because String implements MyInterface
        BoundedClassExampleAgain<MyClass> example = new BoundedClassExampleAgain<>();
        example.printClassName(MyClass.class);
    }
}


class BoundedClassExample2 {
    public static <T extends MyInterface> void printClassName(Class<? extends T> clazz) {
        System.out.println("Class Name: " + clazz.getName());
    }

    public static <T> void printClassNameAgain(Class<? extends T> clazz) {
        System.out.println("Class Name: " + clazz.getName());
    }

    public static void main(String[] args) {
        // Valid usage because String implements MyInterface
        printClassName(MyClass.class);
    }
}

public class BoundedClassExample {
    public static <T> void printClassName(Class<? extends T> clazz) {
        System.out.println("Class Name: " + clazz.getName());
    }

    public static void main(String[] args) {
        printClassName(Integer.class);
        printClassName(Number.class);
        printClassName(Integer.class);
    }
}

