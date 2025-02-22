import java.util.*;

public class VectorEX1 {
    public static void main(String[] args) {
        Vector<Character> vList = new Vector<>();
        vList.add('A');
        vList.add('B');
        vList.add('C');
        vList.add('D');
        vList.add('E');
        vList.add('F');
        vList.add('G');

        System.out.println(vList);

        // Removed
        vList.remove(Character.valueOf('G'));
        System.out.println("\nvList After Removing Elememnt at Index 2: \n" + vList);

        System.out.println("\nCapacity: " + vList.capacity());
        System.out.println("Element at 3 is: " + vList.elementAt(3));

        // Clonning
        Vector<Integer> v = (Vector<Integer>) vList.clone();
        System.out.println("\nCloned Vector is: " + v);

        Vector<Integer> v2 = new Vector<>(v);
        System.out.println("New Cloned Vector is: " + v2);

        // Contains
        System.out.println("\nCheck Wether vList Contains 20 or not: " + vList.contains('F'));

        // Iterator
        System.out.println("\nIterator");
        Iterator<Integer> it = v2.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
    }
}
