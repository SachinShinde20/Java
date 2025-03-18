import java.io.File;
import java.io.IOException;

public class FileEx1 {
    public static void main(String[] args) {

        // 🔹 Step 1: Create a File object
        File file = new File("abc.txt");

        // 🔹 Step 2: Check if the file exists
        if (!file.exists()) {
            try {
                // 🔹 Step 3: Create the file
                boolean isCreated = file.createNewFile();
                System.out.println(isCreated ? "✅ File created successfully!" : "❌ File creation failed!");
            } catch (IOException e) {
                System.err.println("[Error] Unable to create file: " + e.getMessage());
            }
        } else {
            System.out.println("📂 File already exists!");
        }

        // Making File Not Readable, Writable, and Executable
        file.setReadable(false);
        file.setWritable(false);
        file.setExecutable(false);

        // 🔹 Step 4: File Information
        System.out.println("\n🔎 File Information:");
        System.out.println("File Name      : " + file.getName());
        System.out.println("File Path      : " + file.getPath());
        System.out.println("Absolute Path  : " + file.getAbsolutePath());
        System.out.println("Parent Folder  : " + file.getParent());
        System.out.println("Is File         : " + file.isFile());
        System.out.println("Is Directory    : " + file.isDirectory());
        System.out.println("Is Hidden       : " + file.isHidden());
        System.out.println("Readable        : " + file.canRead());
        System.out.println("Writable        : " + file.canWrite());
        System.out.println("Executable      : " + file.canExecute());

        // 🔹 Step 5: File Size (in bytes)
        System.out.println("File Size (bytes): " + file.length());

        // 🔹 Step 6: File Renaming
        file.setReadable(true);
        File renamedFile = new File("renamed_abc.txt");
        if (file.renameTo(renamedFile)) {
            System.out.println("\n✅ File renamed successfully to: " + renamedFile.getName());
        } else {
            System.out.println("\n❌ Failed to rename the file.");
        }

        // 🔹 Step 7: Directory Creation
        File directory = new File("NewDirectory");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("\n✅ Directory created successfully!");
            } else {
                System.out.println("\n❌ Failed to create directory.");
            }
        }

        // 🔹 Step 8: List Files in Directory
        System.out.println("\n📋 Listing Files in Directory:");
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                System.out.println(f.getName()); // Add 2 or 3 files in directory
            }
        } else {
            System.out.println("[Empty Directory]");
        }

        // // 🔹 Step 9: File Deletion
        /*
        if (renamedFile.delete()) {
            System.out.println("\n✅ File deleted successfully!");
        } else {
            System.out.println("\n❌ Failed to delete file.");
        }
         */

        // // 🔹 Step 10: Directory Deletion
        /*
        if (directory.delete()) {
            System.out.println("\n✅ Directory deleted successfully!");
        } else {
            System.out.println("\n❌ Failed to delete Directory.");
        }
        */
    }
}
