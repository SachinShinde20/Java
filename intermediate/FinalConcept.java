// Final Class Cannot be Extended by Any Other Class
// By default every method becomes final inside an final class
final class Ex1 {
    int n = 100;
}

class Ex2 {
    // A final method cannot be overridden by any subclass.
    // By preventing overriding, final methods help maintain the security and
    // reliability of a class’s behavior.
    public final int add(int n1, int n2) {
        return n1 + n2;
    }
}

/*
 * // Compilation Error: The type Ex3 cannot subclass the final class Ex1
 * class Ex3 extends Ex1 {
 * }
 */

/*
 * // Compilation Error: Cannot override the final method from Ex2
 * class Ex4 extends Ex2 {
 * public final int add(int n1, int n2) { // This would cause an error.
 * return n1 + n2;
 * }
 * }
 */

public class FinalConcept {
    public static void main(String[] args) {

        // Cannot Change the Final Variable Once Initialized
        final double pi = 3.14;

        System.out.println("Value of pi: " + pi);
        // pi = 3.15; // Compilation Error: Cannot assign a value to final variable 'pi'

        // We can create obj of final class
        Ex1 ex1 = new Ex1();
        System.out.println(ex1.n);

        // Using the Ex2 class and its final method
        Ex2 ex2 = new Ex2();
        System.out.println("Addition: " + ex2.add(10, 10));

    }
}
