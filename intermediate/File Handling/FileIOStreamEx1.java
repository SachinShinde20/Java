import java.io.*;

public class FileIOStreamEx1 {
    public static void main(String[] args) {

        String fileName = "abc.txt";
        String textData = "Hello, this is a sample text file.";

        // 🔹 Step 1: Writing Data to File
        try (
        /*
        // Takes Url or File as First Parameter, the Second Parameter is for "append mode=true"
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true))
        */
            // By default it is false (No append mode) // Create file if file is not exist
            FileOutputStream fileOutputStream = new FileOutputStream(fileName))
        {
            fileOutputStream.write(textData.getBytes());  // Convert string to bytes and write
            System.out.println("✅ File written successfully: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("[Error] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("[Error] Unable to write data: " + e.getMessage());
        }

        // 🔹 Step 2: Reading Data from File
        try (
                FileInputStream fileInputStream = new FileInputStream(fileName)
        ) {
            System.out.println("\n🔎 File Content:");
            int data;
            while ((data = fileInputStream.read()) != -1) { // Reads data byte by byte from a file.
                System.out.print((char) data); // Convert byte to char
            }
            System.out.println("\n✅ File read successfully: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("[Error] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("[Error] Unable to read data: " + e.getMessage());
        }

        // 🔹 Step 3: File Deletion
        File file = new File(fileName);
        if (file.exists() && file.delete()) {
            System.out.println("\n✅ File deleted successfully: " + fileName);
        } else {
            System.err.println("\n❌ Failed to delete the file or file does not exist.");
        }
    }
}
