import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {
    public static void main(String[] args) {

        // Database connection details
        String URL = "jdbc:mysql://localhost:3306/JDBC"; // Ensure the database name is included in the URL.
        String User = "root";
        String Password = "Pass@123";

        Scanner scanner = new Scanner(System.in);

        // SQL Query using placeholders (?) for dynamic values
        String sqlQuery = "INSERT INTO xyz (id, name, email) VALUES (?, ?, ?);";

        // Load MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver not found!");
            e.printStackTrace();
            return; // Exit if the driver is not found
        }

        // Establishing a connection and preparing the statement
        try (
                Connection connection = DriverManager.getConnection(URL, User, Password);
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)
        ) {
            System.out.println("\n📌 Inserting Records...");

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            // Setting dynamic values in the PreparedStatement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);

            // Executing the INSERT query
            preparedStatement.executeUpdate();
            System.out.println("\n✅ Record inserted successfully!");

        } catch (SQLException e) {
            System.out.println("❌ SQL Exception occurred!");
            e.printStackTrace();
        } finally {
            scanner.close(); // Close scanner to prevent resource leak
        }
    }
}
