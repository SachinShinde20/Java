class Str {
    public void testCode() {
        String s1 = null; // null is a literal that represents the absence of any object.
        // s1.length() Throws NullPointerException

        String s2; // variable s2 might not have been initialized

        String s3 = new String(); // BLank Result
    }

    /*
     * Example 1
     */
    public void StringEx1() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "Hello";
        String str4 = new String("Hello"); // New obj of String
        String str5 = new String("Hello"); // New obj of String

        // ( == ) Compair The obj based on the Address
        System.out.println("\nUsing ==");
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // true
        System.out.println(str1 == str4); // false
        System.out.println(str1 == str5); // false
        System.out.println(str4 == str5); // false

        // ( .equals ) Compair the object with the contents, Not adress of it
        System.out.println("\nUsing .equals");
        System.out.println(str1.equals(str2)); // false
        System.out.println(str1.equals(str3)); // true
        System.out.println(str1.equals(str4)); // true
        System.out.println(str1.equals(str5)); // true
        System.out.println(str4.equals(str5)); // true
    }
}

public class StringEx {
    public static void main(String[] args) {
        Str str = new Str();
        str.StringEx1();
    }
}
