import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterEx {
    public static void main(String[] args) {
        String fileName = "DataStore.txt";

        // 🔹 Using try-with-resources for auto-closing the stream
        try (PrintWriter printWriter = new PrintWriter(fileName)) {

            // 🔹 Writing data to the file
            printWriter.print("Hi, ");              // Writes "Hi, " without a new line
            printWriter.print("Hello, ");           // Writes "Hello, " on the same line
            printWriter.println("Hey This is a Text File"); // Moves to the next line
            printWriter.println(102);               // Writes the integer '102'
            printWriter.println(true);              // Writes boolean 'true'

            printWriter.printf("In this file we can write integers %d, and strings like \"%s\" in to the File.", 10, "Example");

            System.out.println("✅ Data written successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("[Error] File not found: " + e.getMessage());
        }
    }
}
