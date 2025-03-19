import java.io.*;

public class BufferedIOStream {

    // 🔹 Method to Write Data using BufferedOutputStream
    public static void writeData(String fileName, String data) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            bufferedOutputStream.write(data.getBytes()); // Converts String to bytes before writing
            System.out.println("✅ Data written successfully to file: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("[Error] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("[Error] I/O exception: " + e.getMessage());
        }
    }

    // 🔹 Method to Read Data using BufferedInputStream
    public static void readData(String fileName) {
        try (
                FileInputStream fileInputStream = new FileInputStream(fileName);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)
        ) {
            int temp;
            System.out.println("\n📖 Reading data from file: " + fileName);
            while ((temp = bufferedInputStream.read()) != -1) {
                System.out.print((char) temp); // Converts byte data back to characters
            }
            System.out.println("\n✅ Data read successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("[Error] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("[Error] I/O exception: " + e.getMessage());
        }
    }

    // 🔹 Main Method
    public static void main(String[] args) {
        String fileName = "Demo.txt";
        String data = "Hey, this is text.\n*\nFile I/O using Buffered Streams.";

        writeData(fileName, data); // Writing data to file
        readData(fileName);        // Reading data from file
    }
}