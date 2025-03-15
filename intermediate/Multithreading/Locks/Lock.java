class Data {
    private int count;

    // Method to increment the count
    public void increment() {
        // 🔒 Synchronized block ensures thread safety
        // - Locks the current object (`this`) so that only one thread at a time can modify `count`.
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

class IncrementTask extends Thread {
    Data data;

    IncrementTask(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_00_000; i++) {
            data.increment();
        }
    }
}

public class Lock {
    public static void main(String[] args) {
        Data data = new Data();

        IncrementTask t1 = new IncrementTask(data);
        IncrementTask t2 = new IncrementTask(data);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("[Error] Thread interrupted: " + e.getMessage());
        }

        // ✅ Expected output: 200000 (since both threads increment 100000 times each)
        System.out.println("\nFinal Count: " + data.getCount());
    }
}
