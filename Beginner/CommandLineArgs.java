public class CommandLineArgs {
    public static void main(String[] args) {

        // Printing String
        for (String str : args) {
            System.out.println(str);
        }
    }
}

// We can use this for taking input at rutime
// Use -> Choosing file to open, Selecting Port, for quickly taking input.

/*
 * java> javac CommandLineArgs.java
 * Java> java CommandLineArgs Hello This is me "Using Command Line Args"
 * Hello
 * This
 * is
 * me
 * Using Command Line Args
 */