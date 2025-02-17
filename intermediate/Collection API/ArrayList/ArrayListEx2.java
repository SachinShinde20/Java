import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListEx2 {
    public static void main(String[] args) {
        // Creating list1 with initial capacity 15
        ArrayList<String> list1 = new ArrayList<>(15);
        list1.add("Kedar");
        list1.add("Omkar");
        list1.add("Rohan");
        list1.add("Jyoti");
        list1.add("Sakshi");
        list1.add("Atharv");
        list1.add("Rohan");

        // Creating list2 with initial capacity 15
        ArrayList<String> list2 = new ArrayList<>(15);
        list2.add("Jyoti");
        list2.add("Sakshi");

        // Printing lists
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        // HashCode comparison
        System.out.println("\nHashCode of List 1: " + list1.hashCode());
        System.out.println("HashCode of List 2: " + list2.hashCode());

        // Checking equality
        System.out.println("\nIs list1 equal to itself? " + list1.equals(list1)); // Always true
        System.out.println("Is list1 equal to list2? " + list1.equals(list2)); // false

        System.out.println("\n**********************");
        // forEach (Lambda Expression)
        // Use forEach if you only need to read/process elements (no modification).
        System.out.println("Using forEach: (Use forEach if you only need to read/process elements (no modification).)");
        list1.forEach(name -> System.out.print(name + " "));
        System.out.println();

        System.out.println("\n**********************");
        // Iterating using Iterator
        // Use Iterator if you only need to remove elements while iterating.
        System.out.println("Using Iterator: (Use Iterator if you only need to remove elements while iterating.)");
        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Creating list3 with initial capacity 7
        ArrayList<Integer> list3 = new ArrayList<>(7);
        list3.add(8);
        list3.add(0);
        list3.add(3);
        list3.add(9);
        list3.add(0);
        list3.add(2);
        list3.add(7);
        list3.add(0);

        // Printing list3
        System.out.println("\nList 3: " + list3);

        // Iterating using Iterator
        System.out.println("\nUsing Iterator for List 3:");
        Iterator<Integer> it2 = list3.iterator();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
        System.out.println();

        // Printing Even and Odd numbers
        System.out.println("\nChecking Even or Odd using forEach:");
        list3.forEach(num -> {
            if (num % 2 == 0)
                System.out.println("Even: " + num);
            else
                System.out.println("Odd: " + num);
        });

        // Removing all zeros from list3
        System.out.println("\nRemoving all 0s from List 3...");
        list3.removeIf(n -> n.equals(0)); // Using equals() for better type safety
        System.out.println("Updated List 3: " + list3);

        System.out.println("\nRemoving all even numbers from List 3...");
        list3.removeIf(n -> n % 2 == 0);
        System.out.println("Updated List 3: " + list3);

        /*
         * Sorting
         */
        // 1
        System.out.println("\n******* Sorting (sort) *******");
        list3.add(5);
        list3.add(1);
        list3.add(3);
        System.out.println("List 1: \n" + list3);

        Collections.sort(list3);
        System.out.println("Sorted: " + list3);

        // Reverse
        Collections.sort(list3, Collections.reverseOrder());
        System.out.println("Reverse Sorted: " + list3);

        // 2
        System.out.println("\nList 2: \n" + list1);

        Collections.sort(list1);
        System.out.println("Sorted: " + list1);

        // Reversed
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("Reverse Sorted: " + list1);

        System.out.println("\n\n********** ListIterator **********");
        System.out.println("List 3: " + list3);
        // ListIterator
        // Use ListIterator if you need to add, remove, or modify elements.
        // ListIterator is specifically designed for iterating through elements in a
        // List, meaning it is only used for list iteration
        ListIterator<Integer> lit = list3.listIterator();
        while (lit.hasNext()) {
            int n = lit.next();

            if (n == 1) {
                lit.remove(); // Removes 1 from the list safely
            } else if (n % 2 != 0) {
                lit.set(n + 1); // Replaces odd numbers with the next even number
            }
        }

        System.out.println("After Iterating: " + list3);

    }
}

// List 1:[Kedar,Omkar,Rohan,Jyoti,Sakshi,Atharv,Rohan]List 2:[Jyoti,Sakshi]

// HashCode of List 1:755915550
// HashCode of List 2:407860963

// Is list1
// equal to itself?true
// Is list1
// equal to list2?false

// **********************
// Using forEach:(
// Use forEach if
// you only
// need to read/process elements (no modification).)
// Kedar Omkar Rohan Jyoti Sakshi Atharv Rohan

// **********************
// Using Iterator: (Use Iterator if you only need to remove elements while
// iterating.)
// Kedar Omkar Rohan Jyoti Sakshi Atharv Rohan

// List 3: [8, 0, 3, 9, 0, 2, 7, 0]

// Using Iterator for List 3:
// 8 0 3 9 0 2 7 0

// Checking Even or Odd using forEach:
// Even: 8
// Even: 0
// Odd: 3
// Odd: 9
// Even: 0
// Even: 2
// Odd: 7
// Even: 0

// Removing all 0s from List 3...
// Updated List 3: [8, 3, 9, 2, 7]

// Removing all even numbers from List 3...
// Updated List 3: [3, 9, 7]

// ******* Sorting (sort) *******
// List 1:
// [3, 9, 7, 5, 1, 3]
// Sorted: [1, 3, 3, 5, 7, 9]
// Reverse Sorted: [9, 7, 5, 3, 3, 1]

// List 2:
// [Kedar, Omkar, Rohan, Jyoti, Sakshi, Atharv, Rohan]
// Sorted: [Atharv, Jyoti, Kedar, Omkar, Rohan, Rohan, Sakshi]
// Reverse Sorted: [Sakshi, Rohan, Rohan, Omkar, Kedar, Jyoti, Atharv]

// ********** ListIterator **********
// List 3: [9, 7, 5, 3, 3, 1]
// After Iterating: [10, 8, 6, 4, 4]
