class A {
    int a;
    static int b;

    A(int a) {
        this.a = a;
    }

    public void show() {
        System.out.println("a: " + a + ",  b: " + b);
    }
}

public class Static_Ex {
    public static void main(String[] args) {
        A.b = 10;

        A a = new A(11);
        a.show();

        A a2 = new A(22);
        a2.show();

        A a3 = new A(33);
        a3.show();
    }
}
