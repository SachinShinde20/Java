import java.util.ArrayList;

public class BookStore {
    // Static ArrayList to store books
    private static ArrayList<Book> books = new ArrayList<>();

    // Static block to initialize books when the class is loaded
    static {
        // Creating book objects with id, name, author, and price
        Book b1 = new Book(1, "Java Basics", "A. Smith", 299.99f);
        Book b2 = new Book(2, "Python Guide", "B. Johnson", 249.50f);
        Book b3 = new Book(3, "C++ Tricks", "C. Davis", 199.75f);
        Book b4 = new Book(4, "Data Structures", "D. Brown", 399.00f);
        Book b5 = new Book(5, "Web Dev", "E. Wilson", 279.99f);
        Book b6 = new Book(6, "AI & ML", "F. Taylor", 349.00f);
        Book b7 = new Book(7, "Cyber Security", "G. Anderson", 225.25f);

        // Adding books to the list
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
    }

    // Public method to get the books list
    public static ArrayList<Book> getBooks() {
        return books;
    }

    // Used to print the Book details (Used in ArrayListEx2)
    public static void show(ArrayList<Book> book) {
        book.forEach(b -> {
            System.out.print(b.id + ",\t" + b.name + "\t" + b.author + "\t" + b.price + "\n");
        });
    }
}
