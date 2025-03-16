import java.util.Stack;

class Resource {
    public Stack<Integer> stack = new Stack<>();  // Stack to hold integer data
    private int stackItems = 0;                   // Counter to track stack items

    public synchronized void insert(int n) throws InterruptedException {
        // Wait if stack is full (max limit = 5 items)
        while (stackItems >= 5) {
            wait();  // Producer waits until consumer removes items
        }

        // Insert element and update item count
        stack.push(n);
        stackItems++;
        System.out.println("Element " + n + " Inserted in Stack | stackItems: " + stackItems);

        // Notify all waiting threads that an item is available
        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        // Wait if stack is empty (no items to consume)
        while (stackItems <= 0) {
            wait();  // Consumer waits until producer inserts items
        }

        // Remove element and update item count
        int n = stack.pop();
        stackItems--;
        System.out.println("\tElement " + n + " is Deleted from Stack | stackItems: " + stackItems);

        // Notify all waiting threads that space is available
        notifyAll();
    }
}

// Producer thread that inserts data into the stack
class Producer extends Thread {
    private final Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                resource.insert(i);  // Insert element into stack
                //Thread.sleep(100);   // Add delay for better synchronization
            } catch (InterruptedException e) {
                System.err.println("Producer interrupted: " + e.getMessage());
                break;
            }
        }
    }
}

// Consumer thread that removes data from the stack
class Consumer extends Thread {
    private final Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                resource.remove();  // Remove element from stack
                //Thread.sleep(100);  // Add delay for better synchronization
            } catch (InterruptedException e) {
                System.err.println("Consumer interrupted: " + e.getMessage());
                break;
            }
        }
    }
}

public class InterProcessCommunicationEx2 {
    public static void main(String[] args) {
        Resource resource = new Resource();

        // Creating and starting Producer and Consumer threads
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\nStack: "+resource.stack);
    }
}
