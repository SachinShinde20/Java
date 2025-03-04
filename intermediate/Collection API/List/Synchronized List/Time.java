import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;

class Time {
    public static void main(String[] args) {

        int count = 10000000;
        long Start, End;

        /*
         * ---------------
         * ArrayList
         * ---------------
         */
        ArrayList<Integer> l = new ArrayList<>();
        Start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            l.add(i);
        }
        End = System.currentTimeMillis();
        System.out.println("\nTime Required For ArrayList: " + (End - Start) + "ms");

        /*
         * ---------------
         * Syncronized ArrayList
         * Converting Arraylist into Synchronized List
         * ---------------
         */
        List<Object> l2 = Collections.synchronizedList(new ArrayList<>());
        Start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            l2.add(i);
        }
        End = System.currentTimeMillis();
        System.out.println("Time Required For Syncronized ArrayList: " + (End -
                Start) + "ms");

        /*
         * ---------------
         * Vector
         * ---------------
         */
        Vector<Integer> v = new Vector<>();
        Start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            v.add(i);
        }
        End = System.currentTimeMillis();
        System.out.println("Time Required for Vector: " + (End - Start) + "ms");
    }
}