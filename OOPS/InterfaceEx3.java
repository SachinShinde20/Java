// Functional interface with a single abstract method
@FunctionalInterface
interface A {
    void show();
}

class Test {
    /*
     * The @Override annotation indicates that a method overrides
     * a method from a superclass or implements a method from an interface.
     * 
     * The Test class doesn't implement the A interface explicitly.
     * Therefore, Java doesn't recognize the show() method in Test as
     * an implementation of the show() method in A, causing a compilation error.
     */
    public void show() {
        System.out.println("\nShow method is implemented in the parent class 'Test'.");
    }
}

class Testing extends Test implements A {
    // Testing inherits the show() method from Test.

    // Since the Test class already implements the show() method,
    // the Testing class doesn't need to override it.

    // The Test class satisfies the A interface's contract.
}

public class InterfaceEx3 {
    public static void main(String[] args) {
        Testing testing = new Testing();
        testing.show();
    }
}
