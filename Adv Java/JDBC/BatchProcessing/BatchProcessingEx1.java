package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingEx1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC";
        String user = "root";
        String password = "Pass@123";

        String query1 = "INSERT INTO xyz VALUES (301, 'Kapill', 'kapill@gmail.com');";
        String query2 = "INSERT INTO xyz VALUES (302, 'Simran', 'simran@gmail.com');";
        String query3 = "INSERT INTO xyz VALUES (303, 'Mohini', 'mohini@gmail.com');";
        String query4 = "INSERT INTO xyz VALUES (304, 'Vijay', 'vijay@gmail.com');";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                    Connection connection = DriverManager.getConnection(url, user, password);
                    Statement statement = connection.createStatement()
            ) {
                connection.setAutoCommit(false); // Disable auto-commit for batch execution

                // Adding Queries to Batch
                statement.addBatch(query1);
                statement.addBatch(query2);
                statement.addBatch(query3);
                statement.addBatch(query4);

                // Execute Batch
                statement.executeBatch();

                connection.commit(); // Commit transaction
                System.out.println("✅ Batch Execution Successful!");

            } catch (SQLException e) {
                System.err.println("❌ SQL Error Occurred! Rolling Back...");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver Not Found!");
            e.printStackTrace();
        }
    }
}
