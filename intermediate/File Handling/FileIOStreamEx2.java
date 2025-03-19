import java.io.*;

public class FileIOStreamEx2 {

    // 🔹 Source and Destination File Details
    public static String sourceFile = "C:\\Users\\Shachin Shinde\\Downloads\\Google Chrome\\img.jpg";
    public static String destinationFileAddress = "D:\\#_My Folder";
    public static String destinationFileName = "Lord Krishna.jpg";

    public static void main(String[] args) {

        // 🔹 Creating a destination file object
        File destinationFile = new File(destinationFileAddress + "\\" + destinationFileName);

        // 🔹 Try-with-resources for automatic resource management
        try (
                FileInputStream fileInputStream = new FileInputStream(sourceFile); // Input stream for reading data
                FileOutputStream fileOutputStream = new FileOutputStream(destinationFile, true) // Output stream for writing data
        ) {

            /*
            🔹 1st Way -> Reading data in small chunks (1 byte at a time) is slower.
            While this method works, it's inefficient for large files.
            */
//            int data;
//            System.out.println("📂 Reading data (slow method)...");
//            while ((data = fileInputStream.read()) != -1) {
//                fileOutputStream.write(data); // Writing one byte at a time
//            }
//            System.out.println("✅ Data written successfully (slow method)");
//

            /*
            🔹 2nd Way (Recommended) -> Reading data in larger chunks (1 KB at a time)
            Improves speed and performance significantly for large files.
            */
            byte[] buffer = new byte[1024]; // Buffer for efficient data transfer
            int bytesRead; // Holds the number of bytes read in each iteration

            System.out.println("📂 Reading data (efficient method)...");
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead); // Writing only valid data from buffer
            }
            System.out.println("✅ Data written successfully (efficient method)");

        } catch (FileNotFoundException e) {
            System.err.println("❌ [Error] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("❌ [Error] IO Exception: " + e.getMessage());
        }
    }
}