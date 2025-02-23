import java.util.ArrayList;
import java.util.Iterator;

public class VectorEX2 {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        list.add('F');
        list.add('G');

        Iterator<Character> it = list.iterator();
        while (it.hasNext()) {
            char c = it.next();
            if (c == 'G') {
                try {
                    list.set(list.indexOf(c), 'Z');
                    // list.add('Z'); -> ConcurrentModificationException
                    // list.remove(); -> ConcurrentModificationException
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(c);
        }
        System.out.println("\n\nList: " + list);
    }
}

/*
 * ConcurrentModificationException when using list.set(...) because the set
 * method only modifies the existing elements in the list and does not change
 * its structure. The ConcurrentModificationException is typically thrown when
 * the list structure is altered (like adding or removing elements) while
 * iterating through it with an Iterator.
 * 
 * However, if you uncomment the list.add('Z'); line, you will likely get a
 * ConcurrentModificationException because adding an element to the list while
 * iterating changes the list's structure. Here's a bit more detail:
 */
