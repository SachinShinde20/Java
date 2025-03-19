import java.io.*;

public class BufferedRW {

    public static void main(String[] args) {
        String fileName = "Demo.txt";
        String data = "Hey, this is text.\n*\nFile I/O using Buffered Streams.";

        writeData(fileName, data);   // Writing data to the file
        readData(fileName);         // Reading data from the file
    }

    private static void writeData(String fileName, String data) {
        try (
                FileWriter fileWriter = new FileWriter(fileName);     // Create FileWriter
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) // Create BufferedWriter
        ) {
            System.out.println("✍️ Writing data to file...");
            bufferedWriter.write(data);      // Writing data to the file
            bufferedWriter.flush();         // Ensure all buffered data is written
            System.out.println("✅ Data written successfully!\n");
        } catch (IOException e) {
            System.err.println("[Error] Failed to write data: " + e.getMessage());
        }
    }

    private static void readData(String fileName) {
        try (
                FileReader fileReader = new FileReader(fileName);    // Create FileReader
                BufferedReader bufferedReader = new BufferedReader(fileReader) // Create BufferedReader
        ) {
            System.out.println("📖 Reading data from file:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {     // Read file line by line
                System.out.println(line);
            }
            System.out.println("\n✅ Data read successfully!");
        } catch (FileNotFoundException e) {
            System.err.println("[Error] File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("[Error] Failed to read data: " + e.getMessage());
        }
    }
}
