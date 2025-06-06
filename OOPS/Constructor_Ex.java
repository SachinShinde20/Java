class Demo {
    public static String str = "\tInside The Demo Class";
}

public class Constructor_Ex {
    // Constructor
    Constructor_Ex() {
        System.out.println("\nConstructor Called");
        System.out.println(Demo.str);
    }

    // Normal Method
    public void Constructor_Ex() {
        System.out.println("\nNormal Method Callled");
        System.out.println(Demo.str);
    }

    public static void main(String[] args) {
        Constructor_Ex cEx = new Constructor_Ex(); // Contructor Called
        cEx.Constructor_Ex();
    }
}
/*
 * ### Output:
 * In Constructor
 * Inside The Demo
 * 
 * In Normal Method
 * Inside The Demo
 */