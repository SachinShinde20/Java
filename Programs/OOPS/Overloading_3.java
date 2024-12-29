/**********************************************
 * Overloading By Sequence of Parameters (Type Order)
 **********************************************/
// Same can we done to Method Overloding

class Display {
    Display(int a, float b) {
        System.out.println("From: 1");
    }

    Display(float b, int a) {
        System.out.println("From: 2");
    }
}

public class Overloading_3 {
    public static void main(String[] args) {
        Display display1 = new Display(5, 10.5f);
        Display display2 = new Display(10.2f, 5);
    }
}
