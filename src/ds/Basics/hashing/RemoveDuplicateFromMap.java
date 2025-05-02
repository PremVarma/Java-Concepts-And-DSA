package ds.Basics.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateFromMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        map.put("D", 3);
        map.put("E", 2);

        System.out.println("Original HashMap: " + map);
//        removeSuffixDuplicates(map);
//        map = removePrefixDuplicates(map);
        map = removeDuplicatesUsingStreams(map, true);
        System.out.println("HashMap after removing duplicate values: " + map);
    }

    private static <K, V> void removeSuffixDuplicates(HashMap<K, V> map) {
        HashSet<V> seenValues = new HashSet<>();
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            V value = entry.getValue();
            if (!seenValues.add(value)) {
                iterator.remove();
            }
        }
    }

    private static <K, V> HashMap<K, V> removePrefixDuplicates(HashMap<K, V> map) {
        HashMap<V, K> valueToKey = new HashMap<>();
        HashMap<K, V> result = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            valueToKey.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<V, K> entry : valueToKey.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    private static <K, V> HashMap<K, V> removeDuplicatesUsingStreams(HashMap<K, V> map, boolean keepFirst) {
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        LinkedHashMap::new,
                        Collectors.toList()
                )).entrySet().stream().map(entry -> keepFirst ? entry.getValue().get(0) :
                        entry.getValue().get(entry.getValue().size() - 1))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k1, k2) -> k1,
                        HashMap::new));
    }
}
