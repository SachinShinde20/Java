import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Demonstrates various operations on a LinkedList in Java.
 */
public class LinkedListEx1 {
    public static void main(String[] args) {
        // Create a LinkedList of Integer type
        LinkedList<Integer> ll = new LinkedList<>();

        // Adding elements to the LinkedList
        ll.add(10);
        ll.add(25);
        ll.add(43);
        ll.add(15);
        ll.add(21);
        System.out.println("Initial LinkedList: " + ll);

        // Adding elements at the first and last positions
        ll.addFirst(2);
        ll.addLast(70);
        System.out.println("\nAfter addFirst and addLast: " + ll);

        /*
         * Returns true if successful.
         * Does not throw an exception (unlike addFirst() and addLast()).
         * Sometimes if ArrayList is empty, these methods throw an exception.
         */
        // Using offer methods to add elements (similar to add but returns boolean)
        System.out.println("\nOffer 30: " + ll.offer(30)); // Adds at the end
        System.out.println("OfferFirst 5: " + ll.offerFirst(5)); // Adds at the beginning
        System.out.println("OfferLast 75: " + ll.offerLast(75)); // Adds at the end
        System.out.println("After offer operations: " + ll);

        /*
         * Returns null if the list is empty.
         * Sometimes if ArrayList is empty, they throw an exception. Due to this,
         * we use these methods instead.
         */
        // Using poll methods to retrieve and remove elements
        System.out.println("\nPoll(): " + ll.poll()); // Removes first element
        System.out.println("PollFirst(): " + ll.pollFirst()); // Removes first element
        System.out.println("PollLast(): " + ll.pollLast()); // Removes last element
        System.out.println("After poll operations: " + ll);

        /*
         * Returns null if the list is empty.
         */
        // Using peek methods to retrieve elements without removing
        System.out.println("\nPeek(): " + ll.peek()); // Retrieves first element
        System.out.println("PeekFirst(): " + ll.peekFirst()); // Retrieves first element
        System.out.println("PeekLast(): " + ll.peekLast()); // Retrieves last element
        System.out.println("After peek operations: " + ll);

        // Using push method (equivalent to addFirst - Works like stack)
        ll.push(12);
        System.out.println("\nAfter push operation: " + ll);
        // Using pop method (equivalent to removeFirst - Works like stack)
        ll.pop();
        System.out.println("After pop operation: " + ll);

        // Sorting the LinkedList in ascending order
        Collections.sort(ll);
        System.out.println("\nAfter sorting (ascending order): " + ll);

        // Sorting the LinkedList in descending order
        Collections.sort(ll, Collections.reverseOrder());
        System.out.println("\nAfter sorting (descending order): " + ll);

        ll.removeIf(i -> i % 2 == 0);
        System.out.println("\nAfter removeIf (removing even numbers): " + ll);

        System.out.println("\n\n***********************************");

        ll.offerFirst(21);
        ll.offerFirst(12);
        System.out.println("New LinkedList: \n" + ll);

        /*
         * Returns true if an element was removed.
         * If the element is not found, the list remains unchanged.
         */
        System.out.println("Removed First Occurrence of 21: " + ll.removeFirstOccurrence(21));
        System.out.println(ll);
        System.out.println("Removed Last Occurrence of 21: " + ll.removeLastOccurrence(21));
        System.out.println(ll);

        System.out.println("\n\n***********************************");
        // DescendingIterator
        System.out.println("Printing LinkedList using Descending Iterator:");
        Iterator<Integer> it = ll.descendingIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Iterator
        System.out.println("\nPrinting LinkedList using Iterator:");
        it = ll.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // ListIterator
        ListIterator<Integer> it2 = ll.listIterator();
        while (it2.hasNext()) {
            int n = it2.next();
            if (n % 2 != 0) {
                it2.set(n + 1);
            }
        }
        System.out.println("\nAfter adding 1 to all odd numbers using ListIterator:\n" + ll);
    }
}

/*
 * 
 * Initial LinkedList:[10,25,43,15,21]
 * 
 * After addFirst
 * and addLast:[2,10,25,43,15,21,70]
 * 
 * Offer 30:true OfferFirst 5:true OfferLast 75:true
 * After offer operations:[5,2,10,25,43,15,21,70,30,75]
 * 
 * Poll(): 5
 * PollFirst(): 2
 * PollLast(): 75
 * After poll operations: [10, 25, 43, 15, 21, 70, 30]
 * 
 * Peek(): 10
 * PeekFirst(): 10
 * PeekLast(): 30
 * After peek operations: [10, 25, 43, 15, 21, 70, 30]
 * 
 * After push operation: [12, 10, 25, 43, 15, 21, 70, 30]
 * After pop operation: [10, 25, 43, 15, 21, 70, 30]
 * 
 * After sorting (ascending order): [10, 15, 21, 25, 30, 43, 70]
 * 
 * After sorting (descending order): [70, 43, 30, 25, 21, 15, 10]
 * 
 * After removeIf (removing even numbers): [43, 25, 21, 15]
 ***********************************
 * 
 * 
 * New LinkedList:
 * [12, 21, 43, 25, 21, 15]
 * Removed First Occurrence of 21: true
 * [12, 43, 25, 21, 15]
 * Removed Last Occurrence of 21: true
 * [12, 43, 25, 15]
 ***********************************
 * 
 * 
 * Printing LinkedList using Descending Iterator:
 * 15 25 43 12
 * 
 * Printing LinkedList using Iterator:
 * 12 43 25 15
 * 
 * After adding 1 to all odd numbers using ListIterator:
 * [12, 44, 26, 16]
 */