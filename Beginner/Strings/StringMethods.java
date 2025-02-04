public class StringMethods {
    public static void main(String[] args) {
        // Create a sample String
        String str = "Hello, World!";
        String str2 = "  Hello, World!  ";
        String str3 = "Hello, Java!";

        // 1. length(): Returns the length of the string.
        System.out.println("\n1. Length of the string: " + str.length());

        // 2. charAt(index): Returns the character at the specified index.
        System.out.println("\n2. Character at index 7: " + str.charAt(7));

        // 3. substring(start, end): Extracts a substring from the string.
        System.out.println("\n3. Substring from index 7 to 12: " + str.substring(7, 12));

        // 4. toLowerCase(): Converts all characters to lowercase.
        System.out.println("\n4. Lowercase: " + str.toLowerCase());

        // 5. toUpperCase(): Converts all characters to uppercase.
        System.out.println("\n5. Uppercase: " + str.toUpperCase());

        // 6. The trim(): method checks for whitespace characters (Unicode value \u0020)
        // at the beginning and end of the string and removes them.
        // It does not remove whitespace in the middle of the string.
        System.out.println("\n6. Trimmed string: '" + str2.trim() + "'");

        // 7. replace(oldChar, newChar): Replaces all occurrences of a character.
        System.out.println("\n7. Replace 'o' with '0': " + str.replace('o', '0')); // -> Hell0, W0rld!

        // 8. equals(): Compares two strings for content equality.
        System.out.println("\n8. Are 'str' and 'str3' equal? " + str.equals(str3));

        // 9. equalsIgnoreCase(): Compares two strings ignoring case differences.
        System.out.println("\n9. Are 'hello' and 'HELLO' equal (ignoring case)? " + "hello".equalsIgnoreCase("HELLO"));

        // 10. startsWith(prefix): Checks if the string starts with the given prefix.
        System.out.println("\n10. Does 'str' start with 'Hello'? " + str.startsWith("Hello")); // -> true

        // 11. endsWith(suffix): Checks if the string ends with the given suffix.
        System.out.println("\n11. Does 'str' end with 'World!'? " + str.endsWith("World!")); // -> true

        // 12. contains(substring): Checks if the string contains the given substring.
        System.out.println("\n12. Does 'str' contain 'World'? " + str.contains("World")); // -> true

        // Finding the index of 'o'
        // 13. indexOf(char): Returns the index of the first occurrence of the given
        // character.
        System.out.println("\n13. Index of 'o': " + str.indexOf('o'));
        System.out.println("Index of 'o': " + str.indexOf('o', 2)); // This starts searching for 'o' from index 2
                                                                    // onwards. Again, the first 'o' after index 3 is at
                                                                    // index 4. Hence, the result is 4.
        System.out.println("Index of 'o': " + str.indexOf('o', 3));// This starts searching for 'o' from index 3
                                                                   // onwards. Again, the first 'o' after index 3 is at
                                                                   // index 4. Hence, the result is 4.

        // Finding the last index of 'o'
        // 14. lastIndexOf(char): Returns the index of the last occurrence of the given
        // character.
        System.out.println("\n14. Last index of 'o': " + str.lastIndexOf('o'));

        // 15. isEmpty(): Checks if the string is empty.
        System.out.println("\n15. Is 'str' empty? " + str.isEmpty());

        // 16. concat(string): Concatenates two strings.
        System.out.println("\n16. Concatenated string: " + str.concat(" Let's learn Java."));

        // 17. split(regex): Splits the string based on the given regex.
        String[] words = str.split(", ");
        System.out.println("\n17. Words after splitting by ', ': ");
        for (String word : words) {
            System.out.println(word + " ");
        }
        System.out.println();

        // 18. toCharArray(): Converts the string into a character array.
        char[] charArray = str.toCharArray();
        System.out.println("18. Characters in the string: ");
        for (char c : charArray) {
            System.out.println(c);
        }
        System.out.println();

        // 19. compareTo(string): It compares strings based on the Unicode value of each
        // character in the strings.
        // if string1 > string2, -> it returns positive number
        // if string1 < string2, -> it returns negative number
        // if string1 == string2, -> it returns 0
        System.out.println("\n19. Compare 'str' with 'str3': " + str.compareTo(str3));

        // 20. compareToIgnoreCase(string): Lexicographically compares strings ignoring
        // case.
        System.out
                .println("\n20. Compare 'Hello' with 'hello' (ignoring case): " + "Hello".compareToIgnoreCase("hello"));

        // 21. valueOf(): Converts different data types to a string.
        int number = 100;
        System.out.println("\n21. Convert number to string: " + String.valueOf(number));

        // 22. format(): Returns a formatted string.
        String formattedString = String.format("22. Hello %s, you scored %d!", "Alice", 95);
        System.out.println("\n" + formattedString);

        // 23. join(): Joins multiple strings with a delimiter.
        String joinedString = String.join(", ", "Java", "Python", "C++");
        System.out.println("\n23. Joined string: " + joinedString);

        System.out.println();
    }
}
