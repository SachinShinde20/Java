class MainOverride {
    public static void main(String[] args) {
        System.out.println("\tParent Class");
    }
}

public class Introduction_3 extends MainOverride {

    public static void main(int number) {
        System.out.println("Main Method with int signatuere is called");
    }

    public static void main(String[] args) {
        System.out.println("Child Class"); // Child Method Called

        Introduction_3.main(101); // Child Method with Diffrent signature is Called

        String[] str = { "Hello My Name is ..." };
        // objRef.main(args); -> Infinity Loop
        /** or **/
        // objRef.main(str); -> Infinity Loop

        MainOverride.main(str); // Parent Method Called
    }
}

/*
 * ##### Can we overload the main method in Java?
 * Yes.
 * 
 * Method overloading in Java allows a class to have multiple methods with the
 * same name, as long as their parameter lists are different. The differences
 * can be in:
 * 1. Number of parameters: e.g, main(String[] args) vs. main(int x).
 * 2. Type of parameters: e.g, main(String[] args) vs main(int[] numbers).
 * 3. Order of parameters: e.g, main(int x, String s) vs main(String s, int x).
 * 
 * Since the main method is just another method in a class (albeit a special one
 * for execution), it follows the rules of overloading. You can define multiple
 * main methods in a single class with different signatures.
 * 
 * However, there's a crucial point:
 * The Java Virtual Machine (JVM) only recognizes and executes the specific
 * signature public static void
 * main(String[] args) as the program's entry point. Any other overloaded main
 * methods will not be automatically executed by the JVM. If you want to run
 * them, you must explicitly call them from within the standard main method or
 * another part of your code.
 * 
 * 
 * 
 * 
 * ##### Can we override the main method in Java?
 * No.
 * 
 * You cannot override main() in the usual sense because:
 * 1. it's static and static methods belong to the class, not the object.
 * 2. Only instance methods can be overridden using inheritance.
 * 3. JVM's Entry Point Rule: When you run a Java application (e.g., java
 * MyClass), the JVM's sole purpose is to find and execute the public static
 * void main(String[] args) method within the specific class (MyClass) that you
 * told it to run. It doesn't look up the inheritance hierarchy to find a
 * "polymorphically overridden" version of main. It just executes the main
 * method of the class you directly invoked.
 * 
 * However, you can hide it (method hiding), but that’s not the same as true
 * overriding.
 */