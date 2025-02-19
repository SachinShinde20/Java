import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListEx2 {

    // Initializing the book list from BookStore
    private static ArrayList<Book> bookList = new ArrayList<>(BookStore.getBooks());

    public static void main(String[] args) {
        // Adding a new book to the list
        bookList.add(new Book(8, "Core Java", "Cay S. Horstmann", 99f));

        // Modifying the first book in the list (Updating price)
        bookList.set(0, new Book(1, "Java Basics", "A. Smith", 499.50f));

        // Displaying the book list before modifications
        System.out.println("Initial Book List:");
        BookStore.show(bookList);

        // Removing a book by the author's name
        boolean isRemoved = removeBookByAuthor("C. Davis");
        System.out.println("\nBook Removal Status (Author: C. Davis): " + (isRemoved ? "Success" : "Not Found"));
        BookStore.show(bookList);

        // Removing books priced below 100
        bookList.removeIf(book -> book.price < 100);
        System.out.println("\nAfter Removing Books Priced Below 100:");
        BookStore.show(bookList);

        // Increasing the price of all books by 20
        increaseBookPrices(20);
        System.out.println("\nAfter Increasing Book Prices by 20:");
        BookStore.show(bookList);
    }

    /*
     * Removes a book by the given author's name.
     */
    public static boolean removeBookByAuthor(String author) {
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.author.equals(author)) {
                iterator.remove();
                return true; // Book found and removed
            }
        }
        return false; // Book not found
    }

    /*
     * Increases the price of all books in the list by the given amount.
     */
    public static void increaseBookPrices(float amount) {
        // Using ListIterator for modification
        ListIterator<Book> iterator = bookList.listIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            book.price += amount; // Increase price
        }
    }
}