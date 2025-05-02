package basics.collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {
    public static void main(String[] args) {
        SortedMap<String, Integer> map = new TreeMap<>();
        map.put("Prem", 1);
        map.put("Pinky", 2);
        map.put("Abhijit", 3);
        map.put("Neha", 4);
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap("Pinky"));  // start (head ) to this position ( excluded )
        System.out.println(map.tailMap("Pinky")); // from this to last ( tail )
        System.out.println(map.subMap("Abhijit", "Neha"));

    }
}
