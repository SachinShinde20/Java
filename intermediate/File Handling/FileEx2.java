import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileEx2 {
    public static void main(String[] args) {

        String fileName = "NewDirectory";
        File file = new File(fileName);

        // 🔹 Step 1: Display Current Working Directory
        String currentDir = Paths.get("").toAbsolutePath().toString();
        System.out.println("Current Working Directory: " + currentDir);

        // 🔹 Step 2: List Files in Current Directory
        System.out.println("\nFiles in Current Folder:");
        File currentFolder = new File(currentDir);
        File[] subFiles = currentFolder.listFiles();

        if (subFiles != null && subFiles.length > 0) {
            for (File f : subFiles) {
                String result = (f.isDirectory()? "Directory : ":"File : ");
                System.out.println(result+f.getName());
            }
        } else {
            System.out.println("[Empty Directory]");
        }

        System.out.println("\nAbsolute Path of File: " + file.getAbsolutePath());

        // 🔹 Step 3: File Creation
        try {
            if (file.createNewFile()) {
                System.out.println("✅ File created: " + file.getAbsolutePath());
            } else {
                System.out.println("📂 File already exists: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("[Error] Unable to create file: " + e.getMessage());
        }

        // 🔹 Step 4: Mark File for Deletion on JVM Exit
        file.deleteOnExit(); // Marks the file for deletion using deleteOnExit(),
                            // When JVM exits, temp.txt is automatically deleted.
    }
}