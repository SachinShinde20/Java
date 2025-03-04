import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Demonstrates the usage of CopyOnWriteArrayList.
 * CopyOnWriteArrayList is a thread-safe variant of ArrayList where all mutative
 * operations (add, set, remove, etc.)
 * create a new copy of the underlying array, ensuring thread safety without
 * explicit synchronization.
 */
public class CopyOnWriteArrayListEx1 {
    public static void main(String[] args) {
        // Creating a CopyOnWriteArrayList of Integer type
        CopyOnWriteArrayList<Integer> cList = new CopyOnWriteArrayList<>();

        // Adding elements to the list
        cList.add(1);
        cList.add(2);
        cList.add(3);
        cList.add(4);
        cList.add(7);
        cList.add(10);
        cList.add(8);

        // Creating an iterator to traverse the list
        Iterator<Integer> it = cList.iterator();
        while (it.hasNext()) {
            int n = it.next();

            // If the element is 4, add 6 and 5 after it
            if (n == 4) {
                cList.add(cList.indexOf(n) + 1, 6);
                cList.add(cList.indexOf(n) + 1, 5);
            }

            // If the element is 10, remove it from the list
            if (n == 10) {
                cList.remove(cList.indexOf(10));
            }

            // Printing each element
            System.out.println(n);
        }

        // Displaying the final list after modifications
        System.out.println("\n\nFinal cList: " + cList);
    }
}
