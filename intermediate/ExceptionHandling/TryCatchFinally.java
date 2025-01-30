public class TryCatchFinally {
    public static void main(String args[]) {
        String s = null;
        try {
            System.out.println(s.length());
        } catch (Exception e) {
            System.out.println("\nCatch Block is Called...");
            System.err.println(e.getMessage());
        }
        /*
         * We generally use the finally block to execute clean up code like closing
         * connections, closing files, or freeing up threads, as it executes regardless
         * of an exception.
         */
        finally {
            System.out.println("\nFinally Block is called");
        }
    }
}