import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {

        // Creating a final ArrayList of integers
        /*
         * Final Collection:
         * The reference 'numbers' is declared as final, meaning we cannot reassign it
         * to another list. (e.g: numbers = new ArrayList<>(); -> NOT ALLOWED)
         * However, we can still modify the contents of the list (add/remove elements).
         */
        final ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(7);
        numbers.add(9);
        numbers.add(8);
        numbers.add(11);
        numbers.add(6);

        numbers.add(2, 10);
        System.out.println("Final ArrayList after adding 10 at index 2: \n" + numbers);

        numbers.remove(2);
        System.out.println("\nFinal ArrayList after removing element at index 2: \n" + numbers);

        // // Uncommenting the below line will cause a compilation error:
        // numbers = new ArrayList<>();

        // Shuffling elements in the list
        Collections.shuffle(numbers);
        System.out.println("\n\nArrayList after shuffling: \n" + numbers);

        System.out.println("\n\n\n");

        /*
         * Making List Unmodifiable
         */
        // Creating an unmodifiable view of the list, Returns Unmodifiable list
        List<Integer> unmodifiableNumbers = Collections.unmodifiableList(numbers);
        System.out.println("Unmodifiable View: \n" + unmodifiableNumbers);

        // Modifying the original list (changes will reflect in unmodifiableNumbers)
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);
        System.out.println("\nModified Original List: \n" + numbers);
        System.out.println("\nUnmodifiable View After Modification: \n" + unmodifiableNumbers);

        // Trying to modify unmodifiableNumbers directly (throws exception)
        try {
            unmodifiableNumbers.add(80);
        } catch (UnsupportedOperationException e) {
            System.out.println("\tYou cannot modify an unmodifiable list.");
            System.out.println(
                    "\tNote: If the original list (list) is modified, the changes will be reflected in unmodifiableList, So using this technique is not a good approch");
        }

        /*
         * Creating a truly immutable list that won't change if numbers is modified
         * Use List.of() if you’re using Java 9+
         * (creates an immutable list that cannot be modified)
         */
        List<Integer> trulyImmutableList = List.copyOf(numbers);
        System.out.println("\n\n\nTruly Immutable List: \n" + trulyImmutableList);

        // Modifying numbers (will not affect trulyImmutableList)
        numbers.add(90);
        System.out.println("\nModified Original List: \n" + numbers);
        System.out.println("\nTruly Immutable List After Modification: \n" + trulyImmutableList);
    }
}

/*
 * Output:
 * Final ArrayList
 * after adding 10
 * at index 2:[5,2,10,3,1,4,7,9,8,11,6]
 * 
 * Final ArrayList
 * after removing
 * element at index 2:[5,2,3,1,4,7,9,8,11,6]
 * 
 * ArrayList after shuffling:[2,6,7,11,8,1,9,3,5,4]
 * 
 * 
 * 
 * Unmodifiable View:[2,6,7,11,8,1,9,3,5,4]
 * 
 * Modified Original List:[2,6,7,11,8,1,9,3,5,4,50,60,70]
 * 
 * Unmodifiable View
 * After Modification:[2,6,7,11,8,1,9,3,5,4,50,60,70]
 * 
 * You cannot modify an unmodifiable list.Note:
 * If the original list (list) is modified, the changes will be reflected in
 * unmodifiableList, So using this technique is not a good approch
 * 
 * 
 * 
 * Truly Immutable List:
 * [2, 6, 7, 11, 8, 1, 9, 3, 5, 4, 50, 60, 70]
 * 
 * Modified Original List:
 * [2, 6, 7, 11, 8, 1, 9, 3, 5, 4, 50, 60, 70, 90]
 * 
 * Truly Immutable List After Modification:
 * [2, 6, 7, 11, 8, 1, 9, 3, 5, 4, 50, 60, 70]
 */