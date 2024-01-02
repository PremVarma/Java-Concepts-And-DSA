package basics.generics;

public class GenericMethodExample {
    public <K, V> void printValue(KeyValuePair<K, V> pair1, KeyValuePair<K, V> pair2) {
        if (pair1.getKey().equals(pair2.getKey())) {
            System.out.println("Same key found => " + pair1.getValue());
        }
        System.out.println(pair1.getValue() + "-:--" + pair2.getKey());
    }
}
