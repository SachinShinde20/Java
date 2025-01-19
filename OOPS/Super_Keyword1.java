class A {
    int a = 5;

    public void show() {
        System.out.println("Inside Show - A ...");
    }
}

class B extends A {
    int a = 10;

    public void Display() {
        int a = 20;
        System.out.println(a); // 20
        System.out.println(this.a); // 10
        System.out.println(super.a); // 5
    }

    @Override
    public void show() {
        System.out.println("Inside Show - B ...");
        super.show();
    }
}

public class Super_Keyword1 {
    public static void main(String[] args) {

        B bRef = new B();

        bRef.Display();
        bRef.show();
    }
}
