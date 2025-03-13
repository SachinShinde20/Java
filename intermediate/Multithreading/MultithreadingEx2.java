// Class X implements Runnable and overrides the run() method to define its task
class X implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread X is running...");
            try {
                Thread.sleep(500); // Adds a delay of 1/2 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

// Class Y implements Runnable and overrides the run() method to define its task
class Y implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\tThread Y is running...");
            try {
                Thread.sleep(500); // Adds a delay of 1/2 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MultithreadingEx2 {
    public static void main(String[] args) {
        // Creating Runnable instances
        X x = new X();
        Y y = new Y();

        // Creating Thread objects and associating them with Runnable instances
        Thread t1 = new Thread(x);
        Thread t2 = new Thread(y);

        // `start()` initiates the threads and invokes their `run()` method internally
        t1.start();
        t2.start();

        /*
        🌟 Internal Working of `Thread` Creation 🌟

        Step 1: `new Thread()`
        - Creates a Thread object in the JVM heap memory.
        - At this stage, the thread is in the `NEW` state — it is NOT yet an active OS-level thread.

        Step 2: `t1.start()` or `t2.start()`
        - Internally calls the native method `start0()`.
        - `start0()` makes a system call that requests the OS to create a new thread at the OS level.
        - The thread moves from the `NEW` state to the `RUNNABLE` state.

        ⚠️ Important:
        Calling `run()` directly will execute the logic in the **main thread** instead of creating a separate thread.
        */
    }
}
