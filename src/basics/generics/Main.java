package basics.generics;

public class Main {
    public static void main(String[] args) {
        //    Basic Generic
        Person<Integer> intObj = new Person<>(42);
        Person<String> strObj = new Person<>("Hello, Generics!");
        System.out.println(intObj.getValue() + " " + strObj.getValue());

//--------- Inheritance with Generic ---------
        InheritanceWithGenericClass withGenericClass = new InheritanceWithGenericClass("Prem");
        System.out.println(withGenericClass.getValue());

//        Basic -2
        KeyValuePair<String, Integer> pair1 = new KeyValuePair<>("age", 25);
        KeyValuePair<String, Integer> pair3 = new KeyValuePair<>("age", 30);
        KeyValuePair<String, String> pair2 = new KeyValuePair<>("name", "John Doe");
        System.out.println(pair1);  // Output: (age, 25)
        System.out.println(pair2);  // Output: (name, John Doe)

//      Generic Methods
        System.out.println("=================Generic Methods=================");
        GenericMethodExample  genericMethodExample = new GenericMethodExample();
        genericMethodExample.printValue(pair1,pair3);

    }

}
