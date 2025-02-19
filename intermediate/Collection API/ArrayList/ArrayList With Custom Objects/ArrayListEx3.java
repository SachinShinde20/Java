import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Method 1
 */
//  Comparator implementation to sort books by name.
class SortByBookName implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.name.compareTo(o2.name);
    }
}

// Comparator implementation to sort books by price.
class SortByBookPrice implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return Double.compare(o1.price, o2.price); // Simplified price comparison
    }
}

public class ArrayListEx3 {

    // Fetch the list of books from the BookStore
    static ArrayList<Book> books = BookStore.getBooks();

    public static void main(String[] args) {
        System.out.println("Original List of Books:");
        BookStore.show(books);

        // Sorting books by name
        System.out.println("\nSorted Books by Name:");
        Collections.sort(books, new SortByBookName());
        BookStore.show(books);

        // Sorting books by price
        System.out.println("\nSorted Books by Price:");
        Collections.sort(books, new SortByBookPrice());
        BookStore.show(books);

        /*
         * Method 2
         */
        // Sorting books by author name using an anonymous Comparator
        System.out.println("\nSorted Books by Author Name:");
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.author.compareTo(o2.author);
            }
        });
        BookStore.show(books);

        // Sorting books by ID using an anonymous Comparator
        System.out.println("\nSorted Books by Book ID:");
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.id, o2.id);
            }
        });
        BookStore.show(books);
    }
}