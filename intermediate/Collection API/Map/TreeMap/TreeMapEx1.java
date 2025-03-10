import java.util.*;

public class TreeMapEx1 {
    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(245, "Ritesh");
        treeMap.put(249, "Sahil");
        treeMap.put(266, "Shreedhar");
        treeMap.put(219, "Om");
        treeMap.put(241, "Jotiba");
        System.out.println("Original TreeMap: " + treeMap);

        // Creating a reverse-ordered TreeMap
        TreeMap<Integer, String> treeMap1 = new TreeMap<>(Collections.reverseOrder());
        treeMap1.putAll(treeMap);
        System.out.println("\nReversed TreeMap: " + treeMap1);

        // Basic Operations
        System.out.println("\nContains key 244? " + treeMap.containsKey(244));
        System.out.println("Contains value 'Jotiba'? " + treeMap.containsValue("Jotiba"));
        System.out.println("First Key: " + treeMap.firstKey());
        System.out.println("First Entry: " + treeMap.firstEntry());
        System.out.println("Get key 222: " + treeMap.get(222)); // returns null if not found

        // Advanced Operations using ceiling, floor, higher, lower methods
        System.out.println("\nCeiling Key (>= 242): " + treeMap.ceilingKey(242)); // Smallest key >= given key
        System.out.println("Ceiling Entry (>= 242): " + treeMap.ceilingEntry(242));
        System.out.println("Floor Key (<= 255): " + treeMap.floorKey(255)); // Largest key <= given key
        System.out.println("Floor Entry (<= 255): " + treeMap.floorEntry(255));

        System.out.println("\nHigher Entry (after 245): " + treeMap.higherEntry(245)); // Smallest key > given key
        System.out.println("Higher Key (after 245): " + treeMap.higherKey(245));
        System.out.println("Lower Entry (before 245): " + treeMap.lowerEntry(245)); // Greatest key < given key
        System.out.println("Lower Key (before 245): " + treeMap.lowerKey(245));

        System.out.println("\nLast Entry: " + treeMap.lastEntry()); // Returns last entry in the map
        System.out.println("Last Key: " + treeMap.lastKey()); // Returns last key in the map

        // Navigable Key Set
        System.out.println("\nNavigable Key Set: " + treeMap.navigableKeySet());

        // SubMap, HeadMap, TailMap
        System.out.println("\nHeadMap (< 242): " + treeMap.headMap(242)); // All keys < 242
        System.out.println("TailMap (>= 241): " + treeMap.tailMap(241)); // All keys >= 241
        System.out.println("SubMap (220 to 250): " + treeMap.subMap(220, 250)); // Keys from 220 to 250 (excluding 250)

        // Polling first and last entries
        System.out.println("\nPolling first entry: " + treeMap.pollFirstEntry()); // Removes first entry
        System.out.println("Polling last entry: " + treeMap.pollLastEntry()); // Removes last entry
        System.out.println("TreeMap after polling: " + treeMap);

        // Iterating through TreeMap
        System.out.println("\nIterating a TreeMap");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
/*
1️⃣ Lower vs Floor
Method	Returns	Condition
lowerKey(K key)	Greatest key strictly less than key	< key
floorKey(K key)	Greatest key less than or equal to key	≤ key

2️⃣ Higher vs Ceiling
Method	Returns	Condition
higherKey(K key)	Smallest key strictly greater than key	> key
ceilingKey(K key)	Smallest key greater than or equal to key	≥ key

Key Takeaways
lowerKey() excludes the key, while floorKey() includes it.
higherKey() excludes the key, while ceilingKey() includes it.
Think of lower/higher as being strict (< or > only), while floor/ceiling are relaxed (≤ or ≥).
 */