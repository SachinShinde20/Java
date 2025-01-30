public class TryCatch {
    public static void main(String[] args) {

        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            System.out.println("Result: " + (n1 / n2));
        }
        /*
         * When running the program without arguments:
         * java TryCatch
         * This will throw java.lang.ArrayIndexOutOfBoundsException
         */
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("# An Exception Occurred: ArrayIndexOutOfBoundsException\n");
            e.printStackTrace();
        }
        /*
         * When running the program with non-numeric arguments:
         * java TryCatch Hello Hi
         * This will throw java.lang.NumberFormatException
         */
        catch (NumberFormatException e) {
            System.err.println("# An Exception Occurred: NumberFormatException\n");
            e.printStackTrace();
        }
        /*
         * When running the program with zero as the second argument:
         * java TryCatch 10 0
         * This will throw java.lang.ArithmeticException: / by zero
         */
        catch (ArithmeticException e) {
            System.err.println("# An Exception Occurred: ArithmeticException\n");
            e.printStackTrace();
        }
        /*
         * Parent Class of all Exception
         */
        catch (Exception e) {
            System.err.println("# An Exception Occurred\n");
            e.printStackTrace();
        }
    }
}

// System.err.println() -> used to display the errors