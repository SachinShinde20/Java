class Sample {
    // Public Constructor
    public Sample() {
        System.out.println("Public Constructor is Callled.");
    }

    // ### OR ###

    /*
     * Private Construtor -> Output: Sample() has private access in Sample
     * 
     * Explaination:
     * you are not allowed to create objects from outside the class.
     * Only code inside the same class can create objects.
     * 
     * you can’t create an object freely, the class controls the process.
     */
    // private Sample() {
    // System.out.println("Private Constructor is Callled");
    // }
}

public class Constructor_Private {
    public static void main(String[] args) {
        new Sample();
    }
}

/*
 * Modifier Who can use the constructor?
 * public --> Anyone, from anywhere
 * protected --> Only same package or subclasses
 * default --> (no word) Only same package
 * private --> Only inside the same class
 */