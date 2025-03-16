import java.util.Stack;

class Resource {
    boolean isMessageSent; // Flag to track data availability
    public Stack<Integer> stack = new Stack<>();

    // 🔹 Producer inserts data
    public synchronized void insert(int n) throws InterruptedException {
        // ❗ Producer waits if the stack already contains data
        while (isMessageSent) {
            wait(); // Release lock and wait for Consumer to consume
        }

        stack.push(n);  // Add data to the stack
        System.out.println("[Producer] Inserted: " + n);

        isMessageSent = true; // Mark that data is available
        notify(); // Notify Consumer that data is ready
    }

    // 🔹 Consumer removes data
    public synchronized void remove() throws InterruptedException {
        // ❗ Consumer waits if no data is available
        while (!isMessageSent) {
            wait(); // Release lock and wait for Producer to produce
        }

        int n = stack.pop(); // Remove data from the stack
        System.out.println("\t[Consumer] Removed: " + n);

        isMessageSent = false; // Mark that data has been consumed
        notify(); // Notify Producer that the stack is empty
    }
}

// Producer Thread
class Producer extends Thread {
    private final Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            try {
                resource.insert(i); // Insert data
                Thread.sleep(400); // Simulate production delay
            } catch (InterruptedException e) {
                System.err.println("[Producer Error] " + e.getMessage());
                break;
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    private final Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            try {
                resource.remove(); // Remove data
                Thread.sleep(100); // Simulate consumption delay
            } catch (InterruptedException e) {
                System.err.println("[Consumer Error] " + e.getMessage());
                break;
            }
        }
    }
}

// Main class to run the example
public class InterProcessCommunicationEx1 {
    public static void main(String[] args) {
        Resource resource = new Resource(); // Shared resource

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.err.println("[Error] Thread interrupted: " + e.getMessage());
        }

        System.out.println("\n[Execution Completed]");
    }
}
