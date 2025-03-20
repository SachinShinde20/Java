import java.io.*;

public class ObjectIOStream {
    public static void main(String[] args) {

        // 🔹 Creating student objects
        Student s1 = new Student(1, "Raju", "CSE");

        File file = new File("data.txt"); // File to store serialized objects

        // 🔹 Writing objects
        writeData(file, s1);

        // 🔹 Reading objects
        readData(file);
    }

    // 🔹 Method to Write Data to File
    private static void writeData(File sourceFile, Student student) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(sourceFile, true); // Append Mode: True
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(student); // Write each student object
            System.out.println("✅ Objects written successfully!");
        } catch (IOException e) {
            System.err.println("[Error] Unable to write objects: " + e.getMessage());
        }
    }

    // 🔹 Method to Read Data from File
    private static void readData(File file) {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            System.out.println("📖 Reading objects from file...");

            // 🔹 Reading multiple objects until EOF
            try {
                Student student = (Student) objectInputStream.readObject();
                System.out.println(student);
            } catch (EOFException e) {
                System.out.println("✅ All objects read successfully!");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[Error] Unable to read objects: " + e.getMessage());
        }
    }
}