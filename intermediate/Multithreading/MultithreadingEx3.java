public class MultithreadingEx3 {
    public static void main(String[] args) {

        // Using Lambda Expression for Runnable implementation
        Runnable r1 = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Thread 1 is running...");
                try {
                    Thread.sleep(200); // Adds a delay of 1/5 second (200ms)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("\tThread 2 is running...");
                try {
                    Thread.sleep(200); // Adds a delay of 1/5 second (200ms)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
