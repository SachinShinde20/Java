class Counter {
    static int value = 0; // Shared resource prone to race condition
}

class IncrementTask extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1_00_000; i++) {
            increment(); // Correctly synchronized using a block
        }
    }
    // Method 1: Using `synchronized` block (Recommended)
// ➤ Locks only the critical code inside the block (better performance).
// ➤ Uses `Counter.class` to ensure all threads access the shared data safely.
    public void increment() {
        synchronized (Counter.class) {
            Counter.value++; // Ensures only one thread modifies `value` at a time.
        }
    }

    // Method 2: Using `static synchronized` method (Alternative Solution)
// ➤ Locks the entire method (less flexible).
// ➤ Ensures only one thread can run this method at a time.
//    public static synchronized void increment() {
//        Counter.value++;
//    }

}

public class ClassLevelLock {
    public static void main(String[] args) {

        // Creating two thread instances (both modify the same static variable)
        IncrementTask task1 = new IncrementTask();
        IncrementTask task2 = new IncrementTask();

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            System.err.println("[Error] Thread interrupted: " + e.getMessage());
        }

        // ✅ Expected Output: 200000 (Correct result due to proper synchronization)
        System.out.println("\nFinal Counter Value: " + Counter.value);
    }
}
