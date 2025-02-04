import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) {
        // 1. Creating a StringTokenizer object
        String str = "Hello Java World! Welcome to StringTokenizer.";
        StringTokenizer st = new StringTokenizer(str);

        System.out.println("1. Original String: " + str + "\n");

        // 2. Count Tokens
        System.out.println("2. Total Tokens: " + st.countTokens() + "\n");

        // 3. Printing Tokens One by One
        System.out.println("3. Tokens:");
        int i = 1;
        while (st.hasMoreTokens()) {
            System.out.println("   " + (i++) + ". " + st.nextToken());
        }
        System.out.println();

        // 4. Using Different Delimiter
        String data = "Apple,Orange,Mango,Banana,Grapes";
        StringTokenizer st2 = new StringTokenizer(data, ",");

        System.out.println("4. Tokens using ',' as a delimiter:");
        i = 1;
        while (st2.hasMoreTokens()) {
            System.out.println("   " + (i++) + ". " + st2.nextToken());
        }
        System.out.println();
    }
}
