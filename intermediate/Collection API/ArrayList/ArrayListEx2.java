import java.util.ArrayList;
import java.util.Iterator;

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

        // Iterating using forEach (Lambda Expression)
        System.out.println("\nUsing forEach:");
        list1.forEach(name -> System.out.print(name + " "));
        System.out.println();

        // Iterating using Iterator
        System.out.println("\nUsing Iterator:");
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
    }
}
