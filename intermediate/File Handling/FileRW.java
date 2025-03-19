import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRW {
    // 🔹 Method to Write Data to File
    public static void writeData(String fileName, String data) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            System.out.println("🖊️ Writing Data...");
            fileWriter.write(data); // Writing string data to the file
            System.out.println("✅ Data written successfully");
        } catch (IOException e) {
            System.err.println("[Error] Writing Failed: " + e.getMessage());
        }
    }

    // 🔹 Method to Read Data from File
    public static void readData(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            System.out.println("📖 Reading Data...");
            int temp;
            while ((temp = fileReader.read()) != -1) {
                System.out.print((char) temp); // Converting byte data to char
            }
            System.out.println("\n✅ Data read successfully");
        } catch (IOException e) {
            System.err.println("[Error] Reading Failed: " + e.getMessage());
        }
    }

    // 🔹 Main Method
    public static void main(String[] args) {
        String fileName = "Demo.txt";
        String data = "Hey, this is text.\n*\nFile I/O using FileReader and FileWriter.";

        writeData(fileName, data); // Writing Data to File
        readData(fileName);       // Reading Data from File
    }
}