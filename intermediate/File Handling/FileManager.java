import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {

    public static File file = new File("C:\\Users\\Shachin Shinde\\OneDrive\\Desktop");
    public static File newFile;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName, path;

        while (true) {
            System.out.println("\n📂 File Manager Menu:");
            System.out.println("1. Show Current Folder");
            System.out.println("2. Go to Parent Folder");
            System.out.println("3. Open Folder by Name");
            System.out.println("4. Open Folder by Path");
            System.out.println("5. Copy File");
            System.out.println("6. Cut File");
            System.out.println("7. Delete File");
            System.out.println("8. Rename File");
            System.out.println("9. Exit");
            System.out.print("➡️ Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            System.out.println("✅ Your choice: " + choice);

            switch (choice) {
                case 1:
                    System.out.println("\n📁 Current Folder: " + file.getAbsolutePath());
                    showAllFiles(file);
                    break;
                case 2:
                    if (file.getParentFile() != null) {
                        file = file.getParentFile();
                        System.out.println("\n📁 Moved to Parent Folder: " + file.getAbsolutePath());
                        showAllFiles(file);
                    } else {
                        System.out.println("❌ Error: No parent directory exists.");
                    }
                    break; // Added missing break statement
                case 3:
                    System.out.print("\n📁 Enter a folder name to open: ");
                    fileName = sc.nextLine();
                    openFolderByName(fileName);
                    break;
                case 4:
                    System.out.print("\n📁 Enter a folder path to open: ");
                    String folderName = sc.nextLine();
                    openFolderByPath(folderName);
                    break;
                case 5:
                    System.out.print("\n📄 Enter the file name to copy: ");
                    fileName = sc.nextLine();

                    System.out.print("\n📂 Enter the destination path: ");
                    path = sc.nextLine();
                    copyTo(fileName, path);
                    break;
                case 6:
                    System.out.print("\n📄 Enter the file name to cut: ");
                    fileName = sc.nextLine();

                    System.out.print("\n📂 Enter the destination path: ");
                    path = sc.nextLine();
                    cutTo(fileName, path);
                    break;
                case 7:
                    System.out.print("\n📄 Enter a file name for deletion: ");
                    fileName = sc.nextLine(); // Changed from deletionFileName to fileName
                    deleteFile(fileName);
                    break;
                case 8:
                    System.out.print("\n✏️ Enter the file name to rename: ");
                    String oldFileName = sc.nextLine();
                    System.out.print("\n✏️ Enter the new name: ");
                    String newFileName = sc.nextLine();
                    renameFile(oldFileName, newFileName); // Changed from rename to renameFile
                    break;
                case 9:
                    System.out.println("\n👋 Exiting File Manager...");
                    sc.close();
                    return;
                default:
                    System.out.println("\n❌ Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void showAllFiles(File file) {
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("❌ Error: Directory does not exist or is not a valid folder.");
            return;
        }

        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("📂 The folder is empty.");
        } else {
            System.out.println("📂 Files and Folders:");
            Arrays.sort(files);
            // Using more natural indentation and spacing
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println("  📂 " + f.getName());
                } else {
                    System.out.println("  📄 " + f.getName());
                }
            }
        }
    }

    private static void openFolderByName(String fileName) {
        newFile = new File(file, fileName);
        if (!newFile.exists() || !newFile.isDirectory()) {
            System.out.println("❌ Error: Folder does not exist.");
            return;
        }
        file = newFile;
        System.out.println("\n📁 Opened folder: " + file.getAbsolutePath());
        showAllFiles(file);
    }

    private static void openFolderByPath(String folderName) {
        newFile = new File(folderName);
        if (!newFile.exists() || !newFile.isDirectory()) {
            System.out.println("❌ Error: Invalid folder path.");
            return;
        }
        file = newFile;
        System.out.println("\n📁 Opened folder: " + file.getAbsolutePath());
        showAllFiles(file);
    }

    private static void copyTo(String filename, String path) {
        File copyFile = new File(file, filename);
        File destinationFolder = new File(path);
        File newFileLocation = new File(destinationFolder, copyFile.getName()); // Changed from pastFileAddress

        if (!copyFile.exists() || !copyFile.isFile()) {
            System.out.println("❌ Error: The source file does not exist or is not a valid file.");
            return;
        }

        if (!destinationFolder.exists() || !destinationFolder.isDirectory()) {
            System.out.println("❌ Error: Destination path is not a valid directory.");
            return;
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(copyFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFileLocation))) {
            // Using abbreviated variable names for streams - more common in real code

            byte[] buffer = new byte[4096]; // Increased buffer size for better performance
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("✅ File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ I/O Error: " + e.getMessage());
        }
    }

    private static void cutTo(String fileName, String path) {
        File cutFile = new File(file, fileName);
        File destinationFolder = new File(path);
        File newFileLocation = new File(destinationFolder, cutFile.getName()); // Changed from pastFileAddress

        if (!cutFile.exists() || !cutFile.isFile()) {
            System.out.println("❌ Error: The source file does not exist or is not a valid file.");
            return;
        }

        if (!destinationFolder.exists() || !destinationFolder.isDirectory()) {
            System.out.println("❌ Error: Destination path is not a valid directory.");
            return;
        }

        boolean copySuccessful = false;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(cutFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFileLocation))) {

            byte[] buffer = new byte[4096]; // Increased buffer size
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            copySuccessful = true;
        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("❌ I/O Error: " + e.getMessage());
            return;
        }

        if (copySuccessful) {
            if (cutFile.delete()) {
                System.out.println("✅ File cut successfully.");
            } else {
                System.out.println("⚠️ File copied successfully but could not be deleted from the original location.");
            }
        }
    }

    private static boolean deleteFile(String fileName) {
        File deletionFile = new File(file, fileName);

        if (!deletionFile.exists()) {
            System.out.println("❌ Error: The file does not exist.");
            return false;
        }

        if (deletionFile.delete()) {
            System.out.println("✅ File deleted successfully: " + deletionFile.getAbsolutePath());
            return true;
        } else {
            System.out.println("❌ Error: Could not delete the file. It may be in use or read-only.");
            return false;
        }
    }

    private static void renameFile(String oldFileName, String newFileName) { // Changed from rename to renameFile
        File renameFile = new File(file, oldFileName);
        File newFile = new File(file, newFileName);

        if (newFile.exists()) {
            System.out.println("❌ Error: A file with the new name already exists.");
            return;
        }

        if (renameFile.exists() && renameFile.renameTo(newFile)) {
            System.out.println("✅ File renamed successfully.");
        } else {
            System.out.println("❌ Error: Rename failed. Ensure the file exists and the new name is valid.");
        }
    }
}