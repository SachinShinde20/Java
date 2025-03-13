// Class A extends Thread and overrides the run() method to define its task
class A extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread A is running...");
        }
    }
}

// Class B extends Thread and overrides the run() method to define its task
class B extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("\tThread B is running...");
        }
    }
}

public class MultithreadingEx1 {
    public static void main(String[] args) {

        // Displaying the details of the main thread
        System.out.println("Main Thread Name: " + Thread.currentThread().getName());
        System.out.println("Main Thread ID: " + Thread.currentThread().threadId());

        // Creating instances of Thread classes
        A a = new A();
        B b = new B();

        // Displaying and modifying thread priorities
        System.out.println("\nInitial Priority of Thread A: " + a.getPriority());
        System.out.println("Thread A ID: " + a.threadId());
        a.setPriority(Thread.MAX_PRIORITY); // Set maximum priority (10)
        System.out.println("Updated Priority of Thread A: " + a.getPriority());

        System.out.println("\nInitial Priority of Thread B: " + b.getPriority());
        System.out.println("Thread B ID: " + b.threadId());
        b.setPriority(Thread.MIN_PRIORITY); // Set minimum priority (1)
        System.out.println("Updated Priority of Thread B: " + b.getPriority());

        System.out.println("\nStarting the threads");
        // Note: `start()` begins execution in a new thread; calling `run()` directly will not start a new thread.
        a.start();
        b.start();

        /*
        The following happens internally:
        new Thread()
                A Thread object is created in the JVM heap memory, but it’s just an object, not a real OS thread yet.

        t.start() is called
                The JVM internally calls a native method (start0()), which makes a system call to create an OS-level thread.
                The thread moves from the NEW state to the RUNNABLE state.
        */
    }
}
