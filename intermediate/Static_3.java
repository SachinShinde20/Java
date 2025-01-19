class A {
    static int a;

    // Static block is used for assigning vales directy from programme
    static {
        System.out.println("Static Block Called...");
        System.out.println("Value of a: " + a); // 0
    }

    static {
        System.out.println("\nStatic Block-2 Called.....");
    }
}

public class Static_3 {
    public static void main(String[] args) {

        A.a = 1000;
        System.out.println("\nValue of A: " + A.a);
    }
}
