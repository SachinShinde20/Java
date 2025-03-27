import java.sql.*;
import java.util.Scanner;

public class DB_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String query;

        // Try-with-resources ensures proper cleanup of Connection
        try (
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Pass@123");
             Statement statement = connection.createStatement()
        ) {
            // Taking user input for the SQL query
            System.out.print("🔹 Enter your SQL query: ");
            query = sc.nextLine();

            // Executing the query
            statement.execute(query);
            System.out.println("✅ Query executed successfully.");

        } catch (SQLException e) {
            System.err.println("❌ SQL Error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("🔄 Resources closed.");
        }
    }
}
