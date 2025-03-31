package PropertiesDemo;

import java.io.FileReader;
import java.util.Properties;
public class PropertiesExample2 {
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n📂 Reading File...");
            try (
                    FileReader fileReader = new FileReader("D:\\Intel\\JDBC\\JDBC-Connection\\Files\\dbconfigEx.properties");
                ) {
                Properties properties = new Properties();
                properties.load(fileReader);

                System.out.println("✅ Showing Data...");
                // Store values in strings
                String databaseUsername = properties.getProperty("database.username");
                String userPassword = properties.getProperty("database.password");
                String adminPassword = properties.getProperty("database.admin_password");
                String oldPassword = properties.getProperty("database.old_password");
                String recoveryPassword = properties.getProperty("database.recovery_password");

                // Print the stored values
                System.out.println("Database Username: " + databaseUsername);
                System.out.println("User Password: " + userPassword);
                System.out.println("Admin Password: " + adminPassword);
                System.out.println("Old Password: " + oldPassword);
                System.out.println("Recovery Password: " + recoveryPassword);
            } catch (Exception e) {
                System.err.println("❌ Error: " + e.getMessage());
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("⚠ Thread Interrupted");
            }
        }
    }
}
