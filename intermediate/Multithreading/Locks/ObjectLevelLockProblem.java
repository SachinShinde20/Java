class SharedCounter {
    static int counter = 0; // Shared resource (Prone to race condition)
}

class IncrementTask extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1_00_000; i++) {
            increment(); // Potential race condition due to object-level lock
        }
    }

    // 🚨 Object-Level Lock Issue:
    // Since each thread creates its own object, this lock applies per object, NOT across all threads.
    public synchronized void increment() {
        SharedCounter.counter++;
    }
}

public class ObjectLevelLockProblem {
    public static void main(String[] args) {

        // Creating two separate thread objects (Object-level lock issue demonstration)
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

        // 🚨 Expected Output (Incorrect due to race condition): Value < 200000
        System.out.println("\nFinal Counter Value: " + SharedCounter.counter);
    }
}
