import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // Creating a LinkedHashSet of String values
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Sayali");
        linkedHashSet.add("Radhika");
        linkedHashSet.add("Isha");
        linkedHashSet.add("Gayatri");
        linkedHashSet.add("Sonia");
        linkedHashSet.add(null); // LinkedHashSet allows only one null value

        // Printing the initial LinkedHashSet
        System.out.println("Initial LinkedHashSet: " + linkedHashSet);

        // Creating another LinkedHashSet
        LinkedHashSet<String> anotherSet = new LinkedHashSet<>();
        anotherSet.add("Aditi");
        anotherSet.add("Disha");
        anotherSet.add("Ankita");
        anotherSet.add("Pallavi");
        anotherSet.add("Sidhi");

        // Merging the two LinkedHashSets
        linkedHashSet.addAll(anotherSet);
        System.out.println("After adding another set: " + linkedHashSet);

        // Checking the class type
        System.out.println("\nClass Type: " + linkedHashSet.getClass());

        // Checking if the LinkedHashSet is empty
        System.out.println("Is LinkedHashSet empty? " + linkedHashSet.isEmpty());

        // Checking if an element exists in the LinkedHashSet
        System.out.println("Contains 'Sonia'? " + linkedHashSet.contains("Sonia"));

        // Removing elements from the LinkedHashSet
        System.out.println("\nRemoving 'Sonia': " + linkedHashSet.remove("Sonia"));
        System.out.println("Removing null: " + linkedHashSet.removeIf(name -> name == null));
        System.out.println("After removals: " + linkedHashSet);

        // Reversing the LinkedHashSet using .reverse()
        Set<String> revSet = linkedHashSet.reversed();
        System.out.println("\nReversing the LinkedHashSet using (.reverse())\nReversed LinkedHashSet: " + revSet);

        // Reversing the LinkedHashSet manually using a list
        List<String> tempList = new ArrayList<>(linkedHashSet);
        Collections.reverse(tempList);
        LinkedHashSet<String> reversedSet = new LinkedHashSet<>(tempList);
        System.out.println("Reversing the LinkedHashSet manually using a list\nReversed LinkedHashSet: " + reversedSet);

        // Performing retainAll operation (intersection with another set)
        linkedHashSet.retainAll(anotherSet);
        System.out.println("\nAfter retainAll operation: " + linkedHashSet);

        // Converting LinkedHashSet to an array
        String[] arrayRepresentation = linkedHashSet.toArray(new String[0]);
        System.out.println("\nArray representation: " + Arrays.toString(arrayRepresentation));

        // Creating synchronized and unmodifiable versions of the set
        Set<String> synchronizedSet = Collections.synchronizedSet(new LinkedHashSet<>(linkedHashSet));
        Set<String> unmodifiableSet = Collections.unmodifiableSet(new LinkedHashSet<>(linkedHashSet));

        System.out.println("\nUnmodifiable Set: " + unmodifiableSet);

        // Demonstrating UnsupportedOperationException when modifying an unmodifiable
        // set
        try {
            unmodifiableSet.add("This will generate an exception");
        } catch (UnsupportedOperationException e) {
            System.err.println("\nUnsupportedOperationException occurred: Cannot modify an unmodifiable set");
        }

        System.out.println("\nFinal Unmodifiable Set: " + unmodifiableSet);
    }
}

/*
 * Important Notes:
 * 1. The methods getFirst(), getLast(), removeFirst(), and removeLast() are not
 * available in the LinkedHashSet class.
 * These methods were introduced in Java 21 as part of the enhancement for
 * collection interfaces.
 * If using an earlier version of Java, these methods will not be available.
 *
 * 2. The reversed() method does not modify the original set. Instead, it
 * returns a new view that iterates in reverse order.
 * When used with a LinkedHashSet, it should be assigned to a variable to use it
 * effectively.
 */
