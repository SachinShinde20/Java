class A {
    public void show() {
        System.out.println(this);
    }
}

public interface This_Keyword3 {
    public static void main(String[] args) {
        A a;
        a = new A();
        a.show(); // -> A@28a418fc

        a = new A();
        a.show(); // -> A@5305068a

        a = new A();
        a.show(); // -> A@1f32e575
    }
}

/*
 * The class name (A)
 * 
 * The @ symbol
 * 
 * The hexadecimal representation of the object's hash code (memory address or
 * reference), which is why you're seeing something like A@28a418fc.
 * 
 * Each new instance of A you create has a different memory address, so the
 * printed hash codes are different each time you call a.show().
 */