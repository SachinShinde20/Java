import java.util.*;

/**
 * The `Collections.synchronizedMap()` method is used to create a thread-safe version of a standard `HashMap`.
 * Unlike `ConcurrentHashMap`, this method synchronizes the entire map, making it slower under heavy concurrency.
 *
 * Key Features of `Collections.synchronizedMap()`:
 * ✅ Provides thread-safety by synchronizing all access methods.
 * ✅ Suitable for environments with low-to-moderate thread contention.
 * ✅ Allows `null` keys and `null` values (unlike `ConcurrentHashMap`).
 * ❗ Requires external synchronization during iteration to ensure thread safety.
 */

public class SynchronizedMapEx {
    public static void main(String[] args) {
        // Creating a synchronized HashMap instance
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        // Adding elements using `.put()` method
        synchronizedMap.put(201, "John");
        synchronizedMap.put(202, "Jane");
        synchronizedMap.put(203, "Alex");
        synchronizedMap.put(204, "Maria");
        synchronizedMap.put(205, "Robert");

        System.out.println("Initial Synchronized Map: " + synchronizedMap);

        // Retrieving values using `.get()` method
        System.out.println("Value for key 203: " + synchronizedMap.get(203));
        System.out.println("Value for key 300 (Default): " + synchronizedMap.getOrDefault(300, "Not Found"));

        // Checking for key and value presence
        System.out.println("Does key 201 exist? " + synchronizedMap.containsKey(201));
        System.out.println("Does value 'Maria' exist? " + synchronizedMap.containsValue("Maria"));

        // Removing elements using `.remove()`
        synchronizedMap.remove(204);  // Removes entry with key 204
        System.out.println("After removing key 204: " + synchronizedMap);

        // Iterating using `.entrySet()` (with explicit synchronization block)
        System.out.println("\nIterating using entrySet():");
        synchronized (synchronizedMap) {
            for (Map.Entry<Integer, String> entry : synchronizedMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }

        // Checking size
        System.out.println("\nSize of Synchronized Map: " + synchronizedMap.size());

        // Clearing the synchronized map
        synchronizedMap.clear();
        System.out.println("\nAfter clearing: " + synchronizedMap);
    }
}
