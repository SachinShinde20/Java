import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The `ConcurrentHashMap` is a thread-safe collection introduced in Java 1.5 as part of the `java.util.concurrent` package.
 * It is designed for concurrent programming to improve performance in multi-threaded environments.
 *
 * Key Features of `ConcurrentHashMap`:
 * ✅ Thread-safe but with better performance than `Hashtable`.
 * ✅ Allows multiple threads to read and modify without blocking the entire map.
 * ✅ Does NOT allow `null` keys or `null` values.
 * ✅ Uses **segments** (buckets) to reduce lock contention and improve performance.
 * ✅ Ideal for high-concurrency applications where multiple threads access the map.
 *
 * 🔎 Why `ConcurrentHashMap` is Preferred Over `Hashtable`:
 * Unlike `Hashtable`, which locks the entire map for each operation, `ConcurrentHashMap` locks only specific segments (buckets),
 * significantly improving performance by allowing concurrent access to different segments.
 *
 * Final Takeaway
 * If you need a thread-safe map, NEVER use Hashtable! It is outdated and slow.
 * If you just need a quick thread-safe map, use Collections.synchronizedMap(new HashMap<>()), but beware of slow performance.
 * If you need high performance in multi-threaded applications, use ConcurrentHashMap.
 */

public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        // Creating a ConcurrentHashMap instance
        ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        // Adding elements using `.put()` method
        concurrentMap.put(101, "Alice");
        concurrentMap.put(102, "Bob");
        concurrentMap.put(103, "Charlie");
        concurrentMap.put(104, "David");
        concurrentMap.put(105, "Eva");

        System.out.println("Initial ConcurrentHashMap: " + concurrentMap);

        // Retrieving values using `.get()` method
        System.out.println("Value for key 103: " + concurrentMap.get(103)); // Retrieves "Charlie"
        System.out.println("Value for key 200 (Default): " + concurrentMap.getOrDefault(200, "Not Found"));

        // Checking for key and value presence
        System.out.println("Does key 101 exist? " + concurrentMap.containsKey(101));
        System.out.println("Does value 'David' exist? " + concurrentMap.containsValue("David"));

        // Removing elements using `.remove()`
        concurrentMap.remove(104);  // Removes entry with key 104. Thread-safe and does not require external synchronization.
        System.out.println("After removing key 104: " + concurrentMap);

        // Iterating using `.entrySet()`
        System.out.println("\nIterating using entrySet():");
        for (Map.Entry<Integer, String> entry : concurrentMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Checking size
        System.out.println("\nSize of ConcurrentHashMap: " + concurrentMap.size());

        // Clearing the ConcurrentHashMap
        concurrentMap.clear();
        System.out.println("\nAfter clearing: " + concurrentMap);
    }
}
