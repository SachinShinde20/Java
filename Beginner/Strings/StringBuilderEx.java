public class StringBuilderEx {
    public static void main(String[] args) {
        // Creating a StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");

        // 1. Printing initial String
        System.out.println("1. Initial String: " + sb + "\n");

        // 2. Printing Hashcode
        System.out.println("2. Hashcode: " + sb.hashCode() + "\n");

        // 3. append(String s) - Adds text at the end
        sb.append(" World");
        System.out.println("3. After append: " + sb + "\n"); // Output: Hello World

        // 4. insert(int offset, String s) - Inserts text at a specific index
        sb.insert(5, " Java");
        System.out.println("4. After insert: " + sb + "\n"); // Output: Hello Java World

        // 5. replace(int start, int end, String s) - Replaces part of the string
        sb.replace(6, 10, "Python");
        System.out.println("5. After replace: " + sb + "\n"); // Output: Hello Python World

        // 6. delete(int start, int end) - Deletes a portion of the string
        sb.delete(6, 12);
        System.out.println("6. After delete: " + sb + "\n"); // Output: Hello n World

        // 7. reverse() - Reverses the string
        sb.reverse();
        System.out.println("7. After reverse: " + sb + "\n"); // Output: dlroW n olleH

        // 8. reverse() - Reverses again to restore original
        sb.reverse();
        System.out.println("8. After reversing again: " + sb + "\n"); // Output: Hello n World

        // 9. length() - Returns the number of characters
        System.out.println("9. String length: " + sb.length() + "\n"); // Output: 14

        // 10. capacity() - Returns buffer capacity (default 16 + initial length)
        System.out.println("10. StringBuilder capacity: " + sb.capacity() + "\n"); // Output: 31

        // 11. setLength(int newLength) - Changes the length of the buffer
        sb.setLength(10);
        System.out.println("11. After setLength(10): " + sb + "\n"); // Output: dlroW n o

        // 12. ensureCapacity(int minCapacity) - Ensures minimum capacity
        sb.ensureCapacity(50);
        System.out.println("12. After ensureCapacity(50), capacity: " + sb.capacity() + "\n");

        // 13. charAt(int index) - Returns character at a specific index
        System.out.println("13. Character at index 3: " + sb.charAt(3) + "\n"); // Output: 'o'

        // 14. setCharAt(int index, char ch) - Modifies character at a given index
        sb.setCharAt(3, 'X');
        System.out.println("14. After setCharAt(3, 'X'): " + sb + "\n"); // Output: dlrXW n o

        // 15. substring(int start) - Extracts substring from start index
        System.out.println("15. Substring from index 3: " + sb.substring(3) + "\n"); // Output: XW n o

        // 16. substring(int start, int end) - Extracts substring within range
        System.out.println("16. Substring (2, 5): " + sb.substring(2, 5) + "\n"); // Output: rXW
    }
}
