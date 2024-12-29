/**********************************************
 * Overloading By Data Type of Parameters
 **********************************************/
// Same can we done to Constructor Overloding

class Display {
    public void show(int value) {
        System.out.println("Int: " + value);
    }

    public void show(long value) {
        System.out.println("Long: " + value);
    }

    public void show(double value) {
        System.out.println("Double: " + value);
    }

    public void show(String value) {
        System.out.println("String: " + value);
    }

    // public void show(char value) {
    // System.out.println("Char: " + value);
    // }

    public void show(boolean value) {
        System.out.println("Boolean: " + value);
    }
}

public class Overloading_2 {
    public static void main(String[] args) {
        Display display = new Display();

        // Calling overloaded methods with various data types
        display.show(11);
        display.show(9999999999L);
        display.show(10.2f);
        display.show(999.12345);
        display.show("Hello");
        display.show('A');
        display.show(true);

        // Demonstrating string concatenation with other types
        display.show(50 + 7 + " Hello");
    }
}
