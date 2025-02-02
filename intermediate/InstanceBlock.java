// Instance Initializer Block
class Example {
    // Static Block
    static {
        System.out.println("Static Block - Executes once when class is loaded .............");
    }
    // Instance Block
    {
        System.out.println("Instance Block - Executes before constructor");
    }

    // Constructor
    Example() {
        System.out.println("Constructor - Executes when object is created");
    }

    // Method
    void display() {
        System.out.println("Method - Executes when called");
    }
}

public class InstanceBlock {

    public static void main(String[] args) {
        System.out.println("\nMain Method Started");
        new Example().display();

        System.out.println("\nCreating Second Object...");
        new Example().display();

        System.out.println("\nCreating Third Object...");
        new Example().display();
    }
}
// // Static Blocks execute once when the class is loaded.
