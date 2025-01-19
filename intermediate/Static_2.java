class Maths {
    public static float PI = 3.14f;
}

class A {
    public static float Square(float n) {
        return n * n;
    }

    public static float cArea(float r) {
        return Maths.PI * Square(r);
    }
}

public class Static_2 {
    public static void main(String[] args) {
        float n = 10.5f;
        System.out.println("N: " + n);

        System.out.println("Square: " + A.Square(n));
        System.out.println("Area: " + A.cArea(n));
        System.out.println("Pi: " + Maths.PI);
    }
}
