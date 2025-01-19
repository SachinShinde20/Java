class A {
    A() {
        System.out.println("<<< Inside B - Default Constructor");
    }

    A(int n) {
        System.out.println(">>> Inside A - Parameterize Constructor");
    }
}

class B extends A {
    B() {
        super(10);
        System.out.println("<<< Inside B - Default Constructor");
    }
}

class C extends B {
    C() {
        // super(); -> Compiler Creates itself
        System.out.println("<<< Inside C - Default Constructor");
    }
}

public class Super_Keyword2 {
    public static void main(String[] args) {
        new C();
    }
}
