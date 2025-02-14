import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {
    public static void main(String[] args) {
        // Creating two ArrayLists of characters
        ArrayList<Character> list1 = new ArrayList<>();
        list1.add('A');
        list1.add('B');
        list1.add('C');
        list1.add('Z');

        ArrayList<Character> list2 = new ArrayList<>();
        list2.add('W');
        list2.add('X');
        list2.add('Y');

        // Printing initial lists
        System.out.println("Initial Lists:");
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        // Adding elements at specific positions in list1
        list1.add(1, 'a'); // Insert 'a' at index 1
        list1.add(3, 'b'); // Insert 'b' at index 3

        // Printing lists after insertion
        System.out.println("\nAfter adding 'a' and 'b' in List 1:");
        System.out.println("List 1: " + list1);

        // Adding all elements of list2 at index 5 in list1
        list1.addAll(5, list2);
        System.out.println("\nAfter adding List 2 to List 1 at index 5:");
        System.out.println("List 1: " + list1);
        System.out.println("List 2 (unchanged): " + list2);

        // Printing final list and its size
        System.out.println("\nFinal List 1: " + list1);
        System.out.println("Size of List 1: " + list1.size());

        /*
         * Get elements
         */
        System.out.println("\nElements of List 1 using loop:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println(); // New line for better readability

        list1.set(4, 'c');
        System.out.println("\nSet (C -> c): " + list1);

        // Java 21 methods to get the first and last elements
        System.out.println("\n>>> Java 21 Feature <<<");
        System.out.println("First Element: " + list1.getFirst());
        System.out.println("Last Element: " + list1.getLast());

        /*
         * Remove operations
         */
        System.out.println("\n******* Remove Operations *******");

        list1.remove(1); // Removes the element at index 1 (which is 'a')
        System.out.println("After removing index 1 (element 'a'): " + list1);

        list1.remove(Character.valueOf('b')); // Removes the first occurrence of 'b'
        System.out.println("After removing character 'b': " + list1);

        list1.removeAll(list2); // Removes all occurrences of list2 elements from list1
        System.out.println("After removing all elements of List 2 from List 1: " + list1);

        list1.removeIf(e -> e.equals('Z')); // Removes 'Z' from list1
        System.out.println("After removeIf (removing 'Z'): " + list1);

        /*
         * Java 21 features - removeFirst() & removeLast()
         */
        if (!list2.isEmpty()) {
            list2.removeFirst(); // Removes the first element
            list2.removeLast(); // Removes the last element
        }

        /*
         * Clear & Check if Empty
         */
        System.out.println("\nList 2 after removeFirst() & removeLast(): " + list2);
        list2.clear(); // Clears all elements from list2
        System.out.println("List 2 after clear(): " + list2);

        // Checking if lists are empty
        System.out.println("\nIs List 1 Empty? " + list1.isEmpty());
        System.out.println("Is List 2 Empty? " + list2.isEmpty()); // Return True if list is empty

        System.out.println("\n\n***************************************************************");
        // Creating an ArrayList with an initial capacity of 15
        ArrayList<String> list3 = new ArrayList<>(15);
        list3.add("Kedar");
        list3.add("Omkar");
        list3.add("Rohan");
        list3.add("Jyoti");
        list3.add("Sakshi");
        list3.add("Atharv");
        list3.add("Rohan");
        list3.add("Kedar");
        list3.add("Manoj");

        // Printing the original list
        System.out.println("List 3: " + list3);

        // Using indexOf() and lastIndexOf()
        System.out.println("\nFirst occurrence of 'Rohan': " + list3.indexOf("Rohan"));
        System.out.println("Last occurrence of 'Rohan': " + list3.lastIndexOf("Rohan"));

        // Checking if 'Jyoti' is in the list
        System.out.println("\nDoes List 3 contain 'Jyoti'? " + list3.contains("Jyoti"));

        // Creating another list for containsAll() check
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("Sakshi");
        list4.add("Jyoti");

        // Checking if list3 contains all elements of list4
        System.out.println("Does List 3 contain all elements of List 4? " + list3.containsAll(list4));

        // Sublist operation
        List<String> subListNames = list3.subList(0, 6);
        System.out.println("\nSublist (0 to 5): " + subListNames);

        // Unsafe - Suppressing the warning for unchecked cast
        @SuppressWarnings("unchecked")
        ArrayList<String> clonedList = (ArrayList<String>) list4.clone();
        System.out.println("Cloned List (using clone()): " + clonedList);

        // Safe cloning method
        ArrayList<String> list5 = new ArrayList<>(list4);
        System.out.println("Cloned List (using constructor): " + list5);

        // Checking the size before and after trimToSize()
        System.out.println("Size of list5 before trimToSize(): " + list5.size());
        list5.trimToSize(); // Reduces capacity but does not change logical size
        System.out.println("Size of list5 after trimToSize(): " + list5.size());

        /*
         * toArray
         */
        System.out.println("\n************** toArray **************");
        Object[] objArr = list3.toArray();
        System.out.print("Array from list3: ");
        for (Object o : objArr) {
            System.out.print(o + " ");
        }
        System.out.println();

        // Convert list6 to Integer array
        ArrayList<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(2);
        list6.add(3);
        list6.add(4);
        list6.add(5);

        Integer[] arr = list6.toArray(new Integer[0]); // Correct way to convert
        System.out.print("Array from list6: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
