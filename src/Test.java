import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
//        System.out.println("Test"); // Create a new line
//        System.out.printf("%s %d Test", "Sambodhi", 12); //
//        System.out.print("Test"); // Print in single line

//        String test2 = "Premm"; // 65
//        System.out.println(test.compareTo(test2)); //32
//        System.out.println("Roopam".compareTo("Roopan")); // positive // negative //equal
//        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
//
//        treeMap.put("Roopan","Roopam");
//        treeMap.put("Prem","Prem");
//        treeMap.put("Last", "Last");
//        treeMap.put("Arjun","Arjun");
//        System.out.println(treeMap);
        String test = "Prem Prem Prem";
        String test2 = "";// 97
//      Stack and Heap
        int a = 10;
        int b = 20;
        int c = 30;
        double[] arr = new double[10];
        int arr2[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(arr2);

        String abvc = "Prem";
        int ab = 10;

        Person2 p =  new Person2();
        p.id = 2;
        System.out.println(p);
    }


}

class Person2 {
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                '}';
    }
}
