public class NestedTryCatch {
    public static void main(String[] args) {

        /*
         * In Java, We can have nested try-catch blocks, meaning you can place one
         * try-catch block inside another try or catch block.
         */
        try {
            System.out.println("Outer try block");

            try {
                int a = 10 / 0; // ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Division by zero");
            }

            String str = null;
            System.out.println(str.length()); // NullPointerException

        } catch (NullPointerException e) {
            System.out.println("Outer catch: Null pointer exception");
        }

        System.out.println("Program continues...");
    }
}
