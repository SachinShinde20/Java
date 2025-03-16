/*
🔎 Why Does Using notify() Cause Deadlock?
        If you replace notifyAll() with notify(), a deadlock may occur. Here's why:

        notify() Behavior:

        notify() randomly wakes one waiting thread.
        If the awakened thread is another Producer (instead of a Consumer), both producers may go back to waiting without any consumer being notified — creating a deadlock.
        notifyAll() Behavior:

        notifyAll() wakes all waiting threads.
        This ensures that if multiple producers are waiting, at least one Consumer will also be notified, preventing deadlock.
*/
import java.util.Stack;

class Resource {
    public Stack<Integer> stack = new Stack<>();
    private int stackItems = 0;

    public synchronized void insert(int n) throws InterruptedException {
        while (stackItems >= 5) {
            wait();
        }

        stack.push(n);
        stackItems++;
        System.out.println("Element " + n + " Inserted in Stack | stackItems: " + stackItems);

        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while (stackItems <= 0) {
            wait();
        }

        int n = stack.pop();
        stackItems--;
        System.out.println("\tElement " + n + " is Deleted from Stack | stackItems: " + stackItems);

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
        for (int i = 1; i <= 20; i++) { //20 Times
            try {
                resource.insert(i);
                Thread.sleep(100);
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
        for (int i = 1; i <= 40; i++) { //40 Times
            try {
                resource.remove();  // Remove element from stack
                Thread.sleep(100);  // Add delay for better synchronization
            } catch (InterruptedException e) {
                System.err.println("Consumer interrupted: " + e.getMessage());
                break;
            }
        }
    }
}

public class InterProcessCommunicationEx3 {
    public static void main(String[] args) {
        Resource resource = new Resource();

        // Creating and starting Producer and Consumer threads
        Producer producer1 = new Producer(resource);
        Producer producer2 = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer1.start();
        producer2.start();
        consumer.start();

        try {
            producer1.join();
            producer2.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\nStack: "+resource.stack);
    }
}
