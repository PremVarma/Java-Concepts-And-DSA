package basics.collections;
import java.util.*;

public class NavigableMapExample {
    public static void main(String[] args) {
        // Create a NavigableMap (TreeMap) for product inventory
        NavigableMap<Integer, String> inventory = new TreeMap<>();

        // 1. Basic Map Operations (Inherited from Map)
        System.out.println("=== Basic Map Operations ===");
        // put
        inventory.put(101, "Laptop");
        inventory.put(103, "Smartphone");
        inventory.put(102, "Tablet");
        inventory.put(105, "Headphones");
        inventory.put(104, "Smartwatch");
        System.out.println("After put: " + inventory);

        // putAll
        NavigableMap<Integer, String> moreProducts = new TreeMap<>();
        moreProducts.put(106, "Keyboard");
        moreProducts.put(107, "Mouse");
        inventory.putAll(moreProducts);
        System.out.println("After putAll: " + inventory);

        // putIfAbsent
        inventory.putIfAbsent(101, "Desktop"); // Won't overwrite
        inventory.putIfAbsent(108, "Monitor");
        System.out.println("After putIfAbsent: " + inventory);

        // get
        System.out.println("get(102): " + inventory.get(102));

        // getOrDefault
        System.out.println("getOrDefault(999, 'Unknown'): " + inventory.getOrDefault(999, "Unknown"));

        // containsKey
        System.out.println("containsKey(103): " + inventory.containsKey(103));

        // containsValue
        System.out.println("containsValue('Laptop'): " + inventory.containsValue("Laptop"));

        // replace
        inventory.replace(101, "Gaming Laptop");
        System.out.println("After replace(101): " + inventory);

        // replace with old value
        inventory.replace(101, "Gaming Laptop", "Ultrabook");
        System.out.println("After replace(101, oldValue): " + inventory);

        // remove
        inventory.remove(107);
        System.out.println("After remove(107): " + inventory);

        // remove with value
        inventory.remove(106, "Mouse"); // Won't remove since value doesn't match
        inventory.remove(106, "Keyboard");
        System.out.println("After remove(106, 'Keyboard'): " + inventory);

        // size
        System.out.println("size: " + inventory.size());

        // isEmpty
        System.out.println("isEmpty: " + inventory.isEmpty());

        // keySet
        System.out.println("keySet: " + inventory.keySet());

        // values
        System.out.println("values: " + inventory.values());

        // entrySet
        System.out.println("entrySet: " + inventory.entrySet());

        // forEach
        System.out.print("forEach: ");
        inventory.forEach((id, name) -> System.out.print(id + "=" + name + ", "));
        System.out.println();

        // compute
        inventory.compute(101, (k, v) -> v + " (Updated)");
        System.out.println("After compute(101): " + inventory);

        // computeIfAbsent
        inventory.computeIfAbsent(109, k -> "Printer");
        System.out.println("After computeIfAbsent(109): " + inventory);

        // computeIfPresent
        inventory.computeIfPresent(101, (k, v) -> v + " (Pro)");
        System.out.println("After computeIfPresent(101): " + inventory);

        // merge
        inventory.merge(101, " (Merged)", String::concat);
        System.out.println("After merge(101): " + inventory);

        // 2. SortedMap Operations
        System.out.println("\n=== SortedMap Operations ===");
        // comparator
        System.out.println("comparator: " + inventory.comparator()); // null for natural ordering

        // firstKey
        System.out.println("firstKey: " + inventory.firstKey());

        // lastKey
        System.out.println("lastKey: " + inventory.lastKey());

        // subMap (fromKey, toKey)
        System.out.println("subMap(102, 105): " + inventory.subMap(102, 105));

        // headMap (toKey)
        System.out.println("headMap(103): " + inventory.headMap(103));

        // tailMap (fromKey)
        System.out.println("tailMap(104): " + inventory.tailMap(104));

        // 3. NavigableMap Navigation Operations
        System.out.println("\n=== NavigableMap Navigation Operations ===");
        // ceilingEntry
        System.out.println("ceilingEntry(103): " + inventory.ceilingEntry(103));
        System.out.println("ceilingEntry(100): " + inventory.ceilingEntry(100));

        // ceilingKey
        System.out.println("ceilingKey(103): " + inventory.ceilingKey(103));
        System.out.println("ceilingKey(100): " + inventory.ceilingKey(100));

        // floorEntry
        System.out.println("floorEntry(103): " + inventory.floorEntry(103));
        System.out.println("floorEntry(100): " + inventory.floorEntry(100));

        // floorKey
        System.out.println("floorKey(103): " + inventory.floorKey(103));
        System.out.println("floorKey(100): " + inventory.floorKey(100));

        // higherEntry
        System.out.println("higherEntry(103): " + inventory.higherEntry(103));
        System.out.println("higherEntry(109): " + inventory.higherEntry(109));

        // higherKey
        System.out.println("higherKey(103): " + inventory.higherKey(103));
        System.out.println("higherKey(109): " + inventory.higherKey(109));

        // lowerEntry
        System.out.println("lowerEntry(103): " + inventory.lowerEntry(103));
        System.out.println("lowerEntry(101): " + inventory.lowerEntry(101));

        // lowerKey
        System.out.println("lowerKey(103): " + inventory.lowerKey(103));
        System.out.println("lowerKey(101): " + inventory.lowerKey(101));

        // firstEntry
        System.out.println("firstEntry: " + inventory.firstEntry());

        // lastEntry
        System.out.println("lastEntry: " + inventory.lastEntry());

        // pollFirstEntry
        System.out.println("pollFirstEntry: " + inventory.pollFirstEntry());
        System.out.println("After pollFirstEntry: " + inventory);

        // pollLastEntry
        System.out.println("pollLastEntry: " + inventory.pollLastEntry());
        System.out.println("After pollLastEntry: " + inventory);

        // descendingMap
        System.out.println("descendingMap: " + inventory.descendingMap());

        // navigableKeySet
        System.out.println("navigableKeySet: " + inventory.navigableKeySet());

        // descendingKeySet
        System.out.println("descendingKeySet: " + inventory.descendingKeySet());

        // subMap (with inclusive/exclusive)
        System.out.println("subMap(102, true, 105, false): " +
                inventory.subMap(102, true, 105, false));

        // headMap (with inclusive)
        System.out.println("headMap(104, true): " + inventory.headMap(104, true));

        // tailMap (with inclusive)
        System.out.println("tailMap(103, false): " + inventory.tailMap(103, false));

        // clear
        System.out.println("\n=== Clear Map ===");
        inventory.clear();
        System.out.println("After clear: " + inventory);
        System.out.println("isEmpty: " + inventory.isEmpty());
    }
}
