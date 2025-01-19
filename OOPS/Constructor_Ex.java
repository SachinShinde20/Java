class Demo {
    public static String str() {
        String s = "Inside The Demo";
        return s;
    }
}

public class Constructor_Ex {
    // Constructor
    Constructor_Ex() {
        System.out.println("\nIn Constructor");
        System.out.println(Demo.str());
    }

    // Normal Method
    public void Constructor_Ex() {
        System.out.println("\nIn Normal Method");
        System.out.println(Demo.str());
    }

    public static void main(String[] args) {
        Constructor_Ex cEx = new Constructor_Ex(); // Contructor Called
        cEx.Constructor_Ex();
    }
}
