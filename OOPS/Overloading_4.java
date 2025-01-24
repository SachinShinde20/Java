class BaseClass {
    void display() {
        System.out.println("Display method in BaseClass");
    }
}

class OverloadingClass extends BaseClass {
    void display(int x) {
        System.out.println("Overloaded display method in OverloadingClass with value: " + x);
    }
}

class OverloadingClass2 extends OverloadingClass {
    void display(int x, int y) {
        System.out.println("Overloaded display method in OverloadingClass with value: " + x + " & " + y);
    }
}

public class Overloading_4 {
    public static void main(String[] args) {

        OverloadingClass2 ref = new OverloadingClass2();

        // Calling methods
        ref.display();
        ref.display(10);
        ref.display(10, 20);
    }
}