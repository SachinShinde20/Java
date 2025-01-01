class A {
    public static int n = 10;
}

class B extends A {
    public static int n = 20;
}

class C extends B {
    public int n = 30;
}

public class Static_1 {

    static int i = 97;

    public static void main(String[] args) {

        // static int n = 10; //Local Variables Can't be Static
        C cRef = new C();

        // Hiding Static Variables, This is not overriding,
        System.out.println(cRef.n);

        System.out.println(B.n);
        System.out.println(A.n);

        // Not a good practice.
        A aRef = new A();
        System.out.println("\nN: " + aRef.n);
        System.out.println("N: " + A.n);

        // We can directly call a Static variable (Without class name),
        // if it is in same class
        System.out.println("\nNo. " + i);
    }
}