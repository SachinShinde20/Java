import java.util.HashMap;

public class HashMapEx1 {
    public static void main(String[] args) {
        // Creating a HashMap to store Integer keys and String values
        HashMap<Integer, String> hMap = new HashMap<>();
        hMap.put(1, "Virat");
        hMap.put(2, "Rohit");
        hMap.put(3, "Shubman");
        hMap.put(4, "Rahul");
        System.out.println("HashMap 1: \n" + hMap);

        // Creating another HashMap
        HashMap<Integer, String> hMap2 = new HashMap<>();
        hMap2.put(3, "Hardik"); // Overrides "Shubman" for key 3
        hMap2.put(4, "Rahul");
        hMap2.put(5, "Shreyas");
        hMap2.put(6, null); // Allows null values in HashMap
        System.out.println("\nHashMap 2: \n" + hMap2);

        hMap.putAll(hMap2);
        System.out.println("\nMerged HashMap 1: \n" + hMap);

        hMap2.clear();
        System.out.println("\nCleared HashMap 2: \n" + hMap2);

        // Cloning hMap into hMap2
        hMap2 = (HashMap<Integer, String>) hMap.clone();
        System.out.println("\nCloned HashMap 2: \n" + hMap2);

        hMap2.clear(); // Clearing hMap2 again

        // Creating a new HashMap with hMap's entries
        hMap2 = new HashMap<>(hMap);
        System.out.println("\nNew HashMap 2: \n" + hMap2);

        // Checking if hMap is empty
        System.out.println("\nIs HashMap 1 empty? " + hMap.isEmpty());
        System.out.println("Size of HashMap 1: " + hMap.size());
        System.out.println("Values in HashMap 1: " + hMap.values()); // Returns a Collection view of the keys
        System.out.println("Keys in HashMap 1: " + hMap.keySet()); // Returns a Set view of the keys

        // Checking for specific keys and values
        System.out.println("\nDoes HashMap 1 contain key 4? " + hMap.containsKey(4));
        System.out.println("Does HashMap 1 contain value 'Shreyas'? " + hMap.containsValue("Shreyas"));


        // Retrieving a value based on a key
        System.out.println("\nValue for key 1: " + hMap.get(1));

        // `.getOrDefault()` attempts to retrieve the value associated with key `5`. Since key `5` is not present, it returns the default value: `"No Values Found"`.
        System.out.println(hMap.getOrDefault(5, "No Values Found"));
        // `.getOrDefault()` tries to retrieve the value for key `99`. As key `99` is also absent, it again returns the default value.
        System.out.println(hMap.getOrDefault(99, "No Values Found"));

        // Using `putIfAbsent()` - Adds the entry only if the key is not already present.
        hMap.putIfAbsent(1, "Chahal"); //Not added
        System.out.println(hMap);

        hMap.putIfAbsent(11, "Chahal"); //Added
        System.out.println(hMap);

        // Using putIfAbsent() - Only adds if key 6 is absent or mapped to null
        hMap.putIfAbsent(6, "Kuldeep");
        System.out.println("\nUpdated HashMap 1: \n" + hMap);

        // Replacing an existing entry
        hMap.replace(6, "Kuldeep", "Varun"); // Replaces "Kuldeep" with "Varun"
        System.out.println("\nAfter replace operation: \n" + hMap);

        // Attempting to replace a non-matching value (won't work)
        hMap.replace(6, "Hi", "Varun"); // No change as "Hi" is not the current value
        System.out.println("\nAfter unsuccessful replace attempt: \n" + hMap);

        // Printing the HashMap using forEach
        System.out.println("\nPrinting the HashMap using forEach");
        hMap.forEach((k, v)-> {
            System.out.println("Key: " + k + ", \tValue: " + v);
        });
    }
}