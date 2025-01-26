abstract class BluePrint {
    public void show1() {
        System.out.println("In Show 1");
    }

    public static void show2() {
        System.out.println("In Show 2");
    }

    public final void show3() {
        System.out.println("In Show 3");
    }

    abstract void display1();

    abstract void display2();
}

abstract class Test1 extends BluePrint {
    @Override
    public void display1() {
        System.out.println("In Display 1");
    }
}

class Test2 extends Test1 {
    public void display2() {
        System.out.println("In Display 2");
    }
}

public class Abstarct_ex3 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.show1();
        test2.show3();
        test2.show3();

        test2.display1();
        test2.display2();
    }
}