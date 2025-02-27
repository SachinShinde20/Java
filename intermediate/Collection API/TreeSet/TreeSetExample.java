import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetExample {
    public static void main(String[] args) {
        // Creating a TreeSet of integers
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(40);
        treeSet1.add(20);
        treeSet1.add(30);
        treeSet1.add(37);
        treeSet1.add(10);
        treeSet1.add(70);
        treeSet1.add(77);
        // treeSet1.add(null); Not allowed due to comparison based working in treeset
        treeSet1.add(50);
        System.out.println("TreeSet of Integers: " + treeSet1);

        // Creating a TreeSet of Strings
        TreeSet<String> treeSet2 = new TreeSet<>();
        treeSet2.add("Radhika");
        treeSet2.add("Isha");
        treeSet2.add("Gayatri");
        treeSet2.add("Aditi");
        treeSet2.add("Disha");
        treeSet2.add("Ankita");
        treeSet2.add("Pallavi");
        treeSet2.add("Sidhi");
        System.out.println("TreeSet of Strings: " + treeSet2);

        // Removing an element from the TreeSet
        System.out.println("\nRemoving 77: " + treeSet1.remove(77));

        // Checking if a specific element exists
        System.out.println("Contains 10? " + treeSet1.contains(10));

        // Getting the size of the TreeSet
        System.out.println("Size of TreeSet: " + treeSet1.size());

        // Checking if the TreeSet is empty
        System.out.println("Is TreeSet empty? " + treeSet1.isEmpty());

        // Retrieving first and last elements
        System.out.println("\nFirst element: " + treeSet1.first());
        System.out.println("Last element: " + treeSet1.last());

        // Finding elements based on conditions
        System.out.println("\nLower than 30: " + treeSet1.lower(30));
        System.out.println("Floor of 29: " + treeSet1.floor(29)); // Greatest element <= given element
        System.out.println("Ceiling of 25: " + treeSet1.ceiling(25)); // Smallest element >= given element
        System.out.println("Higher than 30: " + treeSet1.higher(30));

        // Creating subsets of the TreeSet
        System.out.println("\nHeadSet (less than 35): " + treeSet1.headSet(35)); // Elements < 35
        System.out.println("TailSet (greater than or equal to 35): " + treeSet1.tailSet(35)); // Elements ≥ 35
        System.out.println("SubSet (between 25 and 60): " + treeSet1.subSet(25, 60)); // Elements in range [25, 60)

        // Removing the first and last elements
        System.out.println("\nRemove First: " + treeSet1.pollFirst());
        System.out.println("Remove Last: " + treeSet1.pollLast());

        System.out.println("Printing Set: " + treeSet1);

        // Removing odd numbers
        System.out.println("\nRemoving The Odd Numbers");
        treeSet1.removeIf(n -> n % 2 != 0);

        // Iterating through the TreeSet in ascending order
        System.out.print("\nTreeSet elements (Ascending): ");
        Iterator<Integer> iterator = treeSet1.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Iterating through the TreeSet in descending order
        System.out.print("\nTreeSet elements (Descending): ");
        iterator = treeSet1.descendingIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
