class Test {
    // Step 2: Static variable is explicitly initialized
    static int num = 10;

    // Step 3: Static block executes
    static {
        System.out.println("Static block is executed!");
        num = 20; // Overwriting num's initial value
    }

    // Static method
    static void display() {
        System.out.println("Static method is called!");
        System.out.println("Value of num: " + num);
    }
}

public class StaticBlockQ1 {
    public static void main(String[] args) {
        System.out.println("Main method starts...");

        // Step 1: Accessing static variable triggers class loading
        System.out.println("Accessing num: " + Test.num);

        // Accessing static method
        Test.display();
    }
}

/*
 * 1️⃣ JVM loads the class if it's not already loaded.
 * 2️⃣ Static variables are first assigned their default values (e.g., `num =
 * 0`).
 * 3️⃣ Explicit static variable initialization happens (e.g., `num = 10`).
 * 
 * 4️⃣ Static blocks execute (e.g., `num = 20`).
 * 5️⃣ Now the class is fully loaded, and execution continues.
 * 
 * This whole process happens reason: If a static variable or static method is
 * accessed and the class is not yet loaded, the JVM loads the class first.
 * thus result in
 * 4️⃣ Static blocks execute (e.g., `num = 20`).
 * 5️⃣ Now the class is fully loaded, and execution continues.
 * 
 * and then the Output is printed.
 */
