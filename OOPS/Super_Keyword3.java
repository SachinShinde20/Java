class Parent {
    Parent() {
        System.out.println("Inside Parent");
    }

    public void property() {
        System.out.println("Parent Property: Gold, Money, Car");
    }
}

class Child extends Parent {
    Child() {
        super();
        this.property();
        super.property();
    }

    @Override
    public void property() {
        System.out.println("Child Property: Land, Bike");
    }
}

public class Super_Keyword3 {
    public static void main(String[] args) {
        new Child();
    }
}