public class WrapperClass {
    public static void main(String[] args) {
        // Demonstration of Integer Wrapper Class
        Integer num = 727; // Autoboxing

        // Conversion methods
        System.out.println("Original Number: " + num);
        System.out.println("To Int Value: " + num.intValue());

        // Parsing and conversions
        String numberString = "1024";
        int parsedNumber = Integer.parseInt(numberString);
        System.out.println("\nParsed Number: " + parsedNumber);

        // Type conversions
        System.out.println("\nHex Representation: " + Integer.toHexString(num));
        System.out.println("Octal Representation: " + Integer.toOctalString(num));
        System.out.println("Binary Representation: " + Integer.toBinaryString(num));

        // Utility methods
        System.out.println("\nMaximum of 10 and 20: " + Integer.max(10, 20));
        System.out.println("Sum of 10 and 20: " + Integer.sum(10, 20));
        System.out.println("Number Reversed: " + Integer.reverse(1234));

        // Boundary value checks
        System.out.println("\nMinimum Integer: " + Integer.MIN_VALUE);
        System.out.println("Maximum Integer: " + Integer.MAX_VALUE);

        // String conversion and validation
        String invalidNumber = "abc";
        try {
            int result = Integer.parseInt(invalidNumber);
            System.out.println("\n" + result);
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid number conversion handled: " + e.getMessage());
        }
    }
}
/*
 * Wrapper Classes Overview:
 * Wrapper classes in Java are used to convert primitive data types into
 * objects. This allows primitive types to be used in object-oriented
 * programming (OOP) scenarios, such as collections, generics, and serialization
 * 
 * type has a corresponding wrapper class:
 * 
 * int → Integer
 * char → Character
 * boolean → Boolean
 * double → Double
 * float → Float
 * short → Short
 * byte → Byte
 * long → Long
 */