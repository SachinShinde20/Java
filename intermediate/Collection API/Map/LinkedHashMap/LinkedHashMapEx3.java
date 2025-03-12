import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEx3 {
    public static void main(String[] args) {
        // LinkedHashMap with access-order enabled (true)
        // Initial Capacity: 8, Load Factor: 0.57
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(8, 0.57f, true);

        // Adding elements
        linkedHashMap.put(1, "Sakshi");
        linkedHashMap.put(2, "Radhika");
        linkedHashMap.put(3, "Siddhi");
        linkedHashMap.put(4, "Pallavi");
        linkedHashMap.put(5, "Mira");
        linkedHashMap.put(6, "Shruti");

        System.out.println("Original LinkedHashMap (Access Order Enabled): \n" + linkedHashMap);

        // Accessing keys to demonstrate access-order functionality
        System.out.println("\nAccessing Key 4: " + linkedHashMap.get(4));
        System.out.println("Accessing Key 2: " + linkedHashMap.get(2));

        // Observe the order shift after accessing keys
        System.out.println("LinkedHashMap after access operations: " + linkedHashMap);

        // Using put() to add or update elements
        linkedHashMap.put(3, "Siddhi Updated");
        System.out.println("\nAfter updating Key 3: " + linkedHashMap);

        // Removing elements
        linkedHashMap.remove(5);
        System.out.println("\nAfter removing Key 5: " + linkedHashMap);

        // Using `putIfAbsent()` to add if the key doesn't already exist
        linkedHashMap.putIfAbsent(7, "Kiran");
        linkedHashMap.putIfAbsent(6, "Shruti Updated"); // Key 6 already exists, so no update
        System.out.println("\nAfter putIfAbsent operations: " + linkedHashMap);

        // Using `replace()` to modify existing values
        linkedHashMap.replace(2, "Radhika Updated");
        System.out.println("\nAfter replacing Key 2's value: " + linkedHashMap);

        // Using `entrySet()` for iteration
        System.out.println("\nIterating using entrySet():");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Clearing the map
        linkedHashMap.clear();
        System.out.println("\nAfter clearing the LinkedHashMap: " + linkedHashMap);
    }
}
