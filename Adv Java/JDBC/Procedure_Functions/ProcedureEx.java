package Procedure_Functions;

import java.sql.*;

public class ProcedureEx  {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pass = "@Pass123";

        // 1. SQL to create a stored procedure
        // (not recommended to do from Java in production)
        String sqlQuery1 = "CREATE PROCEDURE getAllUsers() " +
                "BEGIN " +
                "SELECT * FROM jdbc.users; " +
                "END";

        // 2. SQL to call the stored procedure once it exists
        String sqlQuery2 = "{ CALL getAllUsers() }";

        try (
                Connection connection = DriverManager.getConnection(url, user, pass)
        ) {
            System.out.println("Connected to database successfully.");

            // ⚠️ Creating the procedure
            // (should ideally be done manually in SQL client, not in Java)
            System.out.println("Creating stored procedure 'getAllUsers'...");

            CallableStatement callableStatement = connection.prepareCall(sqlQuery1);
            boolean result = callableStatement.execute();

            if (result) {
                // This branch will almost never be true for CREATE statements, but kept for structure.
                System.out.println("CREATE query returned a result set (unexpected).");
                ResultSet rs = callableStatement.getResultSet();
                while (rs.next()) {
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println(rs.getString(3));
                }
            } else {
                System.out.println("Procedure creation query executed successfully.");
                int rowsAffected = callableStatement.getUpdateCount();
                System.out.println("Rows affected by CREATE query: " + rowsAffected);
            }

            System.out.println("\n----------------------------------------------------\n");

            // Call the stored procedure to get data from 'users' table
            System.out.println("Calling stored procedure 'getAllUsers'...");

            callableStatement = connection.prepareCall(sqlQuery2);
            result = callableStatement.execute();

            if (result) {
                System.out.println("Stored procedure executed successfully. Here is the result:");
                ResultSet rs = callableStatement.getResultSet();
                while (rs.next()) {
                    // Print each column of the current row
                    System.out.print(rs.getInt("id") + "\t");
                    System.out.print(rs.getString("name") + "\t");
                    System.out.println(rs.getString("email"));
                }
            } else {
                System.out.println("Stored procedure did not return a result set.");
                int rowsAffected = callableStatement.getUpdateCount();
                System.out.println("Rows affected by CALL query: " + rowsAffected);
            }

            // Close statement
            callableStatement.close();

        } catch (SQLException e) {
            System.err.println("SQL Exception occurred:");
            e.printStackTrace();
        }
    }
}
