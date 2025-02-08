interface Car {
    int speed = 5; // km

    void control();

    default void vehicle() {
        System.out.println(">>>\tDefault Method");
        System.out.println("This is Car");
    }

    static void model() {
        System.out.println(">>>\tStatic");
        System.out.println("Model is: C15");
    }
}

class RemoteCar implements Car {
    @Override
    public void control() {
        System.out.println("Remote Controlled Car...");
    }
}

class WiredCar implements Car {
    @Override
    public void control() {
        System.out.println("Wired Controlled Car...");
    }
}

class Test implements Car {
    @Override
    public void control() {
        System.out.println("Default Car Model...");
    }

    public void show() {
        System.out.println("Car Speed: " + Car.speed + " km/h");
        Car.model();
    }
}

public class InterfaceEx4 {
    public static void main(String[] args) {
        System.out.println("\nRemote Car:");
        RemoteCar rcCar = new RemoteCar();
        rcCar.control();

        System.out.println("\nWired Car:");
        WiredCar wrCar = new WiredCar();
        wrCar.control();

        System.out.println("\nTest Car: ");
        Test test = new Test();
        test.control();
        test.vehicle();
        test.show();
    }
}
