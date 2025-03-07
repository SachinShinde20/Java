import java.util.*;

public class LinkedHashMapEx1 {
    public static void main(String[] args) {
        // Creating a LinkedHashMap to maintain insertion order
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Viraj");
        linkedHashMap.put(4, "Sonu");
        linkedHashMap.put(5, "Rahul");
        linkedHashMap.put(1, "Rahul");
        linkedHashMap.put(2, "Kedar");
        linkedHashMap.put(7, "Rahul");
        linkedHashMap.put(6, "Nikhil");

        System.out.println("Original LinkedHashMap: " + linkedHashMap);

        // Methods available in Java 21+ (SequencedMap)
        linkedHashMap.putFirst(10, "Dinesh"); // Adds entry at the beginning
        linkedHashMap.putLast(20, "Omkar");  // Adds entry at the end
        System.out.println("\nAfter putFirst and putLast: " + linkedHashMap);

        // Reversing the LinkedHashMap order
        linkedHashMap = new LinkedHashMap<>(linkedHashMap.reversed());
        System.out.println("\nReversed LinkedHashMap: " + linkedHashMap);

        // Retrieving first and last entries
        System.out.println("\nFirst Entry: " + linkedHashMap.firstEntry());
        System.out.println("Last Entry: " + linkedHashMap.lastEntry());

        // Removing first and last entries
        linkedHashMap.pollFirstEntry();
        linkedHashMap.pollLastEntry();
        System.out.println("\nAfter removing first and last entries: " + linkedHashMap);

        // Returning keys in sequence
        SequencedSet<Integer> set1 = linkedHashMap.sequencedKeySet();
        System.out.println("\nSequenced Key Set: " + set1);

        // Returning values in sequence (ensuring unique values using HashSet)
        Set<String> set2 = new HashSet<>(linkedHashMap.sequencedValues());
        System.out.println("\nUnique Sequenced Values: " + set2);

        // Iterating over entries in the LinkedHashMap
        System.out.println("\nIterating over LinkedHashMap:");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", \tValue: " + entry.getValue());
        }
    }
}
