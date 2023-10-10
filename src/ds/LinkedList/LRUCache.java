package ds.LinkedList;
import java.util.*;
import java.util.LinkedList;

class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final Deque<K> lruQueue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.lruQueue = new LinkedList<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null; // Key not in cache
        }

        // Move the accessed key to the front of the queue (most recently used)
        lruQueue.remove(key); // Remove the key from its current position
        lruQueue.addFirst(key); // Add it to the front

        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            // Remove the least recently used key from both cache and queue
            K lruKey = lruQueue.removeLast();
            cache.remove(lruKey);
        }

        // Add the new key to the front of the queue (most recently used)
        lruQueue.addFirst(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3); // Create an LRU cache with a capacity of 3

        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        System.out.println(lruCache.get(2)); // Output: Two (2 is the most recently used)
        System.out.println(lruCache.get(4)); // Output: null (4 is not in the cache)

        lruCache.put(4, "Four"); // Adding a new entry, which should evict the least recently used entry (1=One)
        System.out.println(lruCache.get(1)); // Output: null (1 has been evicted)
    }
}
