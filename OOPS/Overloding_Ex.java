class FigArea {
    // Method to calculate the area of a circle
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Method to calculate the surface area of a cylinder
    public double calculateArea(double radius, double height) {
        return (2 * calculateArea(radius)) + 2 * Math.PI * radius * height;
    }
}

public class Overloding_Ex {
    public static void main(String[] args) {
        FigArea fArea = new FigArea();

        double circleArea = fArea.calculateArea(10);
        System.out.println("Area of Circle: " + circleArea);

        double cylinderArea = fArea.calculateArea(10, 5);
        System.out.println("Surface Area of Cylinder: " + cylinderArea);
    }
}
