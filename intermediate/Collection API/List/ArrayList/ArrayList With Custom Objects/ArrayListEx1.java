import java.util.ArrayList;

public class ArrayListEx1 {

    // Initializing the book list from BookStore
    static ArrayList<Book> l1 = new ArrayList<>(BookStore.getBooks());

    public static void main(String[] args) {

        // Adding a book at index 0
        l1.add(0, new Book(0, "XYZ", "XYZ", 99f));

        // Printing all books in the list
        System.out.println("Initial Book List:");
        System.out.println(l1);

        // Using removeIf to remove books where the name and author are the same
        l1.removeIf(book -> book.name.equals(book.author));
        System.out.println("\nAfter removeIf (Removing books where name == author):");
        System.out.println(l1);

        // Creating a second book list (l2)
        Book s0 = new Book(0, "MNO", "PQR", 99f);
        Book s1 = new Book(1, "Java Basics", "A. Smith", 299.99f);
        Book s2 = new Book(5, "Web Dev", "E. Wilson", 279.99f);
        Book s3 = new Book(7, "Cyber Security", "G. Anderson", 225.25f);
        Book s4 = new Book(2, "ABC", "ABC", 99f);

        // Creating another ArrayList and adding books to it
        ArrayList<Book> l2 = new ArrayList<>();
        l2.add(s0);
        l2.add(s1);
        l2.add(s2);
        l2.add(s3);
        l2.add(s4);

        // Printing the second list
        System.out.println("\nList 2:");
        System.out.println(l2);

        // Removing all elements from l1 that are also in l2
        l1.removeAll(l2);
        System.out.println("\nAfter removeAll (Removing elements in l2 from l1):");
        System.out.println(l1);

        System.out.println("\n*****************************************");
        System.out.println("************ Book Availability *********");
        System.out.println("*****************************************");

        // Checking if a book is available
        System.out.println("Is 'AI & ML' Available? " + isBookAvailable("AI & ML"));
        System.out.println("Is 'F. Taylor' (Author) Available? " + isAuthorAvailable("F. Taylor"));

        // Converting ArrayList to an array
        System.out.println("\nConverting to Array...");
        Book[] bookArray = l1.toArray(new Book[0]);

        // Printing the array elements
        for (Book book : bookArray) {
            System.out.println(book.id + ",\t" + book.name + "\t" + book.author + "\t" + book.price);
        }
    }

    /*
     * Checks if a book with the given name exists in the list.
     */
    public static boolean isBookAvailable(String name) {
        for (Book book : l1) {
            if (book.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Checks if a book by the given author exists in the list.
     */
    public static boolean isAuthorAvailable(String authorName) {
        for (Book book : l1) {
            if (book.author.equals(authorName)) {
                return true;
            }
        }
        return false;
    }
}