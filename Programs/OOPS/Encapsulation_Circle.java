class Circle {
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculateArea() {
        return Math.PI * (radius * 2);
    }

    public double calculateCircumference() {
        return 2 * (Math.PI * radius);
    }
}

class Encapsulation_Circle {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(105);

        System.out.println("Radius: " + c.getRadius());
        System.out.println("Area of Circle: " + c.calculateArea());
        System.out.println("Circle Circumference: " + c.calculateCircumference());
    }
}
