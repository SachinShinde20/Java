import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {

        /*
         * try-with-resources is a feature introduced in Java 7 that allows the
         * automatic management of resources such as files, sockets, database
         * connections, etc. It ensures that resources are closed automatically at the
         * end of the try block, eliminating the need for explicit finally blocks.
         * 
         * Why Use Try-With-Resources?
         * Before Java 7, resources like file streams or database connections had to be
         * closed manually using finally. This often led to resource leaks if the
         * programmer forgot to close them.
         */
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
