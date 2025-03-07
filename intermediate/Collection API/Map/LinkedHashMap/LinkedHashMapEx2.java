import java.util.*;

class Payment {
    String name;
    int amount;

    public Payment(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}

public class LinkedHashMapEx2 {
    public static void main(String[] args) {
        // Creating a LinkedHashMap to maintain insertion order
        LinkedHashMap<Integer, Payment> linkedHashMap = new LinkedHashMap<>();

        // Adding records to the LinkedHashMap
        linkedHashMap.put(104, new Payment("Emma", 1200));
        linkedHashMap.put(105, new Payment("David", 450));
        linkedHashMap.put(106, new Payment("Sarah", 900));
        linkedHashMap.put(107, new Payment("Michael", 650));
        linkedHashMap.put(101, new Payment("John", 500));
        linkedHashMap.put(102, new Payment("Alice", 750));
        linkedHashMap.put(103, new Payment("Bob", 300));

        // Printing the original LinkedHashMap
        System.out.println("Original LinkedHashMap: " + linkedHashMap);

        // Reversing the order of the LinkedHashMap (Java 21+ feature)
        linkedHashMap = new LinkedHashMap<>(linkedHashMap.reversed());
        System.out.println("\nReversed LinkedHashMap: " + linkedHashMap);

        // Retrieving and printing the keys in sequence
        SequencedSet<Integer> set = linkedHashMap.sequencedKeySet();
        System.out.println("\nSequenced Key Set: " + set);

        // Retrieving and printing the values in sequence
        SequencedCollection<Payment> collection = linkedHashMap.sequencedValues();
        System.out.println("\nSequenced Values: " + collection);

        // Iterating and printing the entries in sequence
        SequencedSet<Map.Entry<Integer, Payment>> entries = linkedHashMap.sequencedEntrySet();
        System.out.println("\nIterating over LinkedHashMap:");
        for (Map.Entry<Integer, Payment> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", \tValue: " + entry.getValue());
        }
    }
}