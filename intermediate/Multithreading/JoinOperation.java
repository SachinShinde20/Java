import java.util.Arrays;

class Database {
    public static final int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};

    public static final char[] arr2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'};
}

// Collect1 class to store integer data in a separate thread
class Collect1 implements Runnable {
    int[] db1 = new int[Database.arr1.length];

    @Override
    public void run() {
        for (int i = 0; i < Database.arr1.length; i++) {
            db1[i] = Database.arr1[i];
            System.out.println(Thread.currentThread().getName() + " → Data Added: " + db1[i]);
        }
    }
}

// Collect2 class to store character data in a separate thread
class Collect2 implements Runnable {
    char[] db2 = new char[Database.arr2.length];

    @Override
    public void run() {
        for (int i = 0; i < Database.arr2.length; i++) {
            db2[i] = Database.arr2[i];
            System.out.println("\t"+Thread.currentThread().getName() + " → Data Added: " + db2[i]);
        }
    }
}

// Main class to manage thread execution and data display
public class JoinOperation {
    public static void main(String[] args) {

        Collect1 collect1 = new Collect1();
        Collect2 collect2 = new Collect2();

        Thread t1 = new Thread(collect1, "Collector 1");
        Thread t2 = new Thread(collect2, "Collector 2");

        t1.start();
        t2.start();

        try {
            // Ensuring both threads complete before proceeding
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("[Error] Thread interrupted: " + e.getMessage());
        }
        //    Without join the main Thread will Execute next instructions and does not wait for the other threads to complete its execution or task
        //      result in wrong or irregular incorrect output

        printData(collect1.db1, collect2.db2);
    }

    public static void printData(int[] db1, char[] db2) {
        System.out.println("\n[Final Data] Numbers: " + Arrays.toString(db1));
        System.out.println("[Final Data] Characters: " + Arrays.toString(db2));
    }
}
