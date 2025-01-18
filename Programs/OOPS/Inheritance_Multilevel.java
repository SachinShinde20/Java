class Vehicle {
    String brand;
    int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    String fuelType;

    public Car(String brand, int speed, String fuelType) {
        super(brand, speed);
        this.fuelType = fuelType;
    }

    public void displayFuelType() {
        System.out.println("Fuel Type: " + fuelType);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    public ElectricCar(String brand, int speed, String fuelType, int batteryCapacity) {
        super(brand, speed, fuelType);
        this.batteryCapacity = batteryCapacity;
    }

    public void displayBatteryDetails() {
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

public class Inheritance_Multilevel {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar("Tesla", 200, "Electric", 100);

        electricCar.displayInfo();
        electricCar.displayFuelType();
        electricCar.displayBatteryDetails();
    }
}
