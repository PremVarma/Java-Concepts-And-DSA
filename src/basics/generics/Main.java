package basics.generics;

public class Main {
    public static void main(String[] args) {
        //    Basic Generic
        MyGenericClass<Integer> intObj = new MyGenericClass<>(42);
        MyGenericClass<String> strObj = new MyGenericClass<>("Hello, Generics!");
        System.out.println(intObj.getValue() + " " + strObj.getValue());

//        Basic -2
        KeyValuePair<String, Integer> pair1 = new KeyValuePair<>("age", 25);
        KeyValuePair<String, String> pair2 = new KeyValuePair<>("name", "John Doe");

        System.out.println(pair1);  // Output: (age, 25)
        System.out.println(pair2);  // Output: (name, John Doe)

        pair1.setKey("newAge");
        pair1.setValue(30);

        System.out.println(pair1);
    }

}
