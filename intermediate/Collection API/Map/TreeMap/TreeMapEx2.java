import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

class Workers implements Comparable<Workers> {
    String name;
    int hours;

    public Workers(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Worker{name='" + name + "', hours=" + hours + "}";
    }

    // Sorting Workers based on their names (lexicographically)
    @Override
    public int compareTo(Workers o) {
        return this.name.compareTo(o.name);
    }
}

public class TreeMapEx2 {
    public static void main(String[] args) {

        // TreeMap with Workers as keys and Integer as values
        TreeMap<Workers, Integer> treeMap = new TreeMap<>();

        // Creating Worker objects
        Workers w1 = new Workers("Kishor", 5);
        Workers w2 = new Workers("Shamir", 2);
        Workers w3 = new Workers("Monal", 8);
        Workers w4 = new Workers("Veer", 6);
        Workers w5 = new Workers("Abdul", 4);

//        Duplicate entries - not taken
        Workers w6 = new Workers("Kishor", 7);
        Workers w7 = new Workers("Kishor", 4);

        // Adding workers to TreeMap (sorted by name)
        treeMap.put(w1, 101);
        treeMap.put(w2, 102);
        treeMap.put(w3, 103);
        treeMap.put(w4, 104);
        treeMap.put(w5, 105);

        // Display the original TreeMap (sorted by name)
        System.out.println("Original TreeMap: " + treeMap);

        // Ceiling Entry - First entry whose key is >= given key
        System.out.println("\nCeiling Entry (>= Kishor): " + treeMap.ceilingEntry(w1));

        // Floor Entry - First entry whose key is <= given key
        System.out.println("Floor Entry (<= Monal): " + treeMap.floorEntry(w3));

        // Higher Entry - Entry whose key is strictly greater than given key
        System.out.println("Higher Entry (after Kishor): " + treeMap.higherEntry(w1));

        // Lower Entry - Entry whose key is strictly less than given key
        System.out.println("Lower Entry (before Kishor): " + treeMap.lowerEntry(w1));

        // SubMap, HeadMap, TailMap
        System.out.println("\nHeadMap (before Monal): " + treeMap.headMap(w3));
        System.out.println("TailMap (from Monal onwards): " + treeMap.tailMap(w3));

        // Polling first and last entries
        System.out.println("\nPolling first entry: " + treeMap.pollFirstEntry());
        System.out.println("Polling last entry: " + treeMap.pollLastEntry());
        System.out.println("TreeMap after polling: " + treeMap);

        // Iterating through TreeMap
        System.out.println("\nIterating through TreeMap:");
        for (Map.Entry<Workers, Integer> entry : treeMap.entrySet()) {
            Workers worker = entry.getKey();
            System.out.println("Name: " + worker.name + ", Hours: " + worker.hours + ", ID: " + entry.getValue());
        }
    }
}
