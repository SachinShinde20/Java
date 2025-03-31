package PropertiesDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        String propertiesFile = "D:\\Intel\\JDBC\\JDBC-Connection\\Files\\dbconfigExample.properties";

        try {
            /*
            * Reading Data From .properties File
            */
            // Load properties file
            FileInputStream fis = new FileInputStream(propertiesFile);
            Properties properties = new Properties();
            properties.load(fis);
            fis.close();

            // Display initial property values
            System.out.println("Initial Database Configuration:");
            System.out.println("URL: " + properties.getProperty("db.url", "Not Found"));
            System.out.println("User: " + properties.getProperty("db.user", "Not Found"));
            System.out.println("Password: " + properties.getProperty("db.password", "Not Found"));
            System.out.println("Driver: " + properties.getProperty("db.driver", "Not Found"));
            System.out.println("Timeout: " + properties.getProperty("db.timeout", "Not Found"));

            /*
             * Writing Data to .properties File
             */
            // Modify some values
            System.out.println("\nModifying Properties...");
            properties.setProperty("db.password", "newPassword123"); // Update password
            properties.setProperty("db.timeout", "120"); // Increase timeout

            // Save updated properties
            FileOutputStream fos = new FileOutputStream(propertiesFile);
            properties.store(fos, "Database Configuration Updated");
            fos.close();


            /*
             * Reading Data From .properties File again
             */
            // Display updated values
            System.out.println("\nUpdated Database Configuration:");
            System.out.println("URL: " + properties.getProperty("db.url"));
            System.out.println("User: " + properties.getProperty("db.user"));
            System.out.println("Password: " + properties.getProperty("db.password"));
            System.out.println("Driver: " + properties.getProperty("db.driver"));
            System.out.println("Timeout: " + properties.getProperty("db.timeout"));

        } catch (IOException e) {
            System.err.println("Error handling properties file: " + e.getMessage());
        }
    }
}
