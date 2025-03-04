import java.util.*;

public class HashSetEx1 {
    public static void main(String[] args) {

        // Creating a HashSet of Integer values
        HashSet<Integer> hashSet = new HashSet<>();

        // Adding elements to the HashSet
        hashSet.add(10);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(7);
        hashSet.add(6);
        hashSet.add(null); // HashSet allows one null value
        hashSet.add(1);
        hashSet.add(9);

        // Printing the HashSet (order is not guaranteed)
        System.out.println("HashSet elements: " + hashSet);

        // Removing specific elements from the HashSet
        hashSet.remove(6);
        hashSet.remove(9);
        System.out.println("After removing 6 and 9: " + hashSet);

        // Removing null value if present
        hashSet.removeIf(n -> n == null);
        System.out.println("After removing null: " + hashSet);

        // Checking if an element exists in the HashSet
        System.out.println("Contains 4? " + hashSet.contains(4));

        // Checking if the HashSet is empty
        System.out.println("Is HashSet empty? " + hashSet.isEmpty());

        // Getting the size of the HashSet
        System.out.println("HashSet size: " + hashSet.size());

        // Converting HashSet to an array
        Integer[] arr = hashSet.toArray(new Integer[0]);
        System.out.println("Array length: " + arr.length);
        System.out.println("Array representation: " + Arrays.toString(arr));

        // Iterating over the HashSet using an Iterator
        Iterator<Integer> iterator = hashSet.iterator();
        System.out.print("Iterating HashSet: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("\n***************************\n");
        Set<Integer> synchronizedHashSet = Collections.synchronizedSet(hashSet);
        System.out.println("Synchronized HashSet: " + synchronizedHashSet);

        Set<Integer> unmodifiableHashSet = Collections.unmodifiableSet(Set.copyOf(hashSet));
        System.out.println("Unmodifiable HashSet: " + unmodifiableHashSet);

        System.out.println("\n***************************\n");

        // Creating two HashSets for set operations
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        // Checking if set1 contains all elements of set2
        System.out.println("set1 contains all elements of set2? " + set1.containsAll(set2));

        // Performing intersection (retain common elements)
        set1.retainAll(set2);
        System.out.println("Intersection of set1 and set2: " + set1);
    }
}
