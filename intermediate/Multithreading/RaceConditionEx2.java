class Alphabet {
    // // Using `StringBuffer` (Mutable) - Thread-safe (Uncomment below to test)
     public static StringBuffer str = new StringBuffer("A");

    // // Using `String` (Immutable) - Not thread-safe
    //  public static String str = "A";
}

class Add extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " [Thread] is Working");
        for (int i = 0; i < 1_00_000; i++) {
            // // Using `StringBuffer` for thread-safe concatenation (Uncomment below to test)
             Alphabet.str.append("a");

            // // Using `String` for immutable concatenation (Active code)
            // Alphabet.str = Alphabet.str.concat("a");
        }
    }
}

// Main class to test Race Condition
public class RaceConditionEx2 {
    public static void main(String[] args) {
        Add add1 = new Add();
        add1.setName("Add 1");

        Add add2 = new Add();
        add2.setName("Add 2");

        add1.start();
        add2.start();

        try {
            add1.join();
            add2.join();
        } catch (InterruptedException e) {
            System.out.println("[Error] Thread interrupted: " + e.getMessage());
        }

        // Expected Output:
        // When using `StringBuffer`: Length = 2_00_001 - (Faster)
        // When using `String`: Length may vary due to race condition (Slower Due to each time a new Object is created in String Pool)
        System.out.println("\n" + Alphabet.str.length());
    }
}
