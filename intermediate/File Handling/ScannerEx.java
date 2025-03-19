import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerEx {

    public static void main(String[] args) {
        String fileName = "Temp.txt";

        readData(fileName);
    }

    private static void readData(String fileName) {
        File file = new File(fileName);

        // 🔹 Check if the file exists before proceeding
        if (!file.exists()) {
            System.err.println("❌ Error: File '" + fileName + "' not found!");
            return;
        }

        try (
                Scanner scanner = new Scanner(file)  // Scanner object to read file content
        ) {
            System.out.println("📖 Reading data from '" + fileName + "':\n");

            // 🔹 Read file content line by line
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            System.out.println("\n✅ Data read successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("[Error] File not found: " + fileName);
        }
    }
}
