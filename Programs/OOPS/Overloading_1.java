/**********************************************
 * Overloading By Number of Parameters
 **********************************************/
// Same can we done to Method Overloding
class Display {
    int a, b, c;

    Display() {
        a = b = c = 1;
    }

    Display(int x) {
        a = b = c = x;
    }

    Display(int x, int y, int z) {
        a = x;
        b = y;
        c = z;
    }

    public void show() {
        System.out.println("A: " + a + "\nB: " + b + "\nC: " + c);
    }
}

public class Overloading_1 {
    public static void main(String[] args) {

        System.out.println("Calling Default");
        Display display = new Display();
        display.show();

        System.out.println("\nCalling Constructor with Single parameter");
        Display display2 = new Display(7);
        display2.show();

        System.out.println("\nCalling Constructor with Three parameter");
        Display display3 = new Display(11, 22, 33);
        display3.show();
    }
}
