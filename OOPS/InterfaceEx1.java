interface Vehicle {

    // all Data Members in an interface were implicitly public PUBLIC, STATIC, FINAL
    int CONST_NO = 10;

    // all methods in an interface were implicitly abstract and public
    void start();

    void stop();

    /*
     * * From Java 8:
     * * java introduced default methods (methods with a body) and static methods in
     * * interfaces.
     */

    // * default method
    default void display1() {
        System.out.println("This is 1st default method in the interface.");
    }

    default void display2() {
        System.out.println("This is 2nd default method in the interface.");
    }

    // * Static Methods
    static void show() {
        System.out.println("This is a static method in the interface.");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is Running...");
    }

    @Override
    public void stop() {
        System.out.println("Car is Stoped...");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is Running...");
    }

    @Override
    public void stop() {
        System.out.println("Bike is Stoped...");
    }

    @Override // Overriden Interface Method -> display()
    public void display1() {
        System.out.println("This is a default method in the interface, Which is Overriden by Bike");
    }
}

public class InterfaceEx1 {
    public static void main(String[] args) {

        // Car
        System.out.println("\nCar: ");
        Car car = new Car();
        car.start();
        car.stop();
        System.out.println(Vehicle.CONST_NO);
        car.display1();
        car.display2();
        Vehicle.show();

        // Bike
        System.out.println("\nBike: ");
        Bike bike = new Bike();
        bike.start();
        bike.stop();
        System.out.println("Constant Value from Interface: " + Vehicle.CONST_NO);
        bike.display1();
        Vehicle.show();
    }
}