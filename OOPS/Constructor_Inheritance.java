class A {
    A() {
        // super() ->> >By Default Present Here (obj class)
        System.out.println("Class A");
    }
}

class B extends A {
    // JVM internally create default constructor
    // Super is present in that default constructor
}

class C extends B {
    C() {
        // super() ->>> By Default Present Here (call B class's Constructor)
        System.out.println("Class c");
    }
}

public class Constructor_Inheritance {
    public static void main(String[] args) {
        new C();
    }
}
