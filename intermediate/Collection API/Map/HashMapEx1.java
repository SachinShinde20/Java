import java.util.HashMap;
import java.util.Set;

public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap<Integer, String> hMap = new HashMap<>();
        hMap.put(1, "Virat");
        hMap.put(2, "Rohit");
        hMap.put(3, "Shubhaman");
        hMap.put(4, "Rahul");
        System.out.println("HashMap 1: \n"+hMap);

        HashMap<Integer, String> hMap2 = new HashMap<>();
        hMap2.put(3, "Hardik"); //Override Shubhaman
        hMap.put(4, "Rahul");
        hMap2.put(5, "Shreyash");
        System.out.println("\nHashMap 2: \n"+hMap2);

        hMap.putAll(hMap2);
        System.out.println("\nHashMap 1: \n"+hMap);

        hMap2.clear();
        System.out.println("\nHashMap 2: \n"+hMap2);

        //Clone
        hMap2 = (HashMap<Integer, String>) hMap.clone();
        System.out.println("\nHashMap 2: \n"+hMap2);

        hMap2.clear();
        System.out.println("\nHashMap 2: \n"+hMap2);

        hMap2= new HashMap<>(hMap);
        System.out.println("\nHashMap 2: \n"+hMap2);

        //
        System.out.println(hMap.isEmpty());
        System.out.println(hMap.size());
        System.out.println(hMap.values());
        System.out.println(hMap.keySet()); //Returns set Set<Integer> set = hMap.keySet();
    }
}
