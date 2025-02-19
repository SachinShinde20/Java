import java.util.ArrayList;
import java.util.Collections;

class Novel implements Comparable<Novel> {
    private String title;
    private String author;
    private double price;

    public Novel(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /*
     * Displays the list of novels in a formatted manner.
     */
    public static void show(ArrayList<Novel> novels) {
        novels.forEach(novel -> System.out.println(novel.title + " \tby " + novel.author + "\t - $" + novel.price));
    }

    /*
     * Compares novels based on the author's name for sorting.
     */
    @Override
    public int compareTo(Novel other) {
        return this.author.compareTo(other.author);
    }
}

// Main class
public class ArrayListEx4 {
    public static void main(String[] args) {
        // Creating a list of novels
        ArrayList<Novel> novels = new ArrayList<>();
        novels.add(new Novel("Novel A", "Charles Dickens", 10.99));
        novels.add(new Novel("Novel B", "Mark Twain", 12.50));
        novels.add(new Novel("Novel C", "Jane Austen", 9.99));
        novels.add(new Novel("Novel D", "Roy", 7.99));

        // Displaying the original list of novels
        System.out.println("Original List of Novels:");
        Novel.show(novels);

        // Sorting novels by author's name
        System.out.println("\nSorted Novels by Author's Name:");
        Collections.sort(novels);
        Novel.show(novels);
    }
}
