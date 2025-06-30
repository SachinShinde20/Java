package Procedure_Functions;

import java.sql.*;

public class DynamicProcedureEx {
    public static void main(String[] args) throws SQLException {
        /*
         * Stored Procedure expected in database:
         * --------------------------------------
         * CREATE PROCEDURE jdbc.getUserById(IN userId INT)
         * BEGIN
         *     SELECT * FROM users WHERE id = userId;
         * END
         */

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pass = "@Pass123";

        // SQL query to call the stored procedure with one input parameter
        String sqlQuery = "{ CALL jdbc.getUserById(?) }";

        try (
                Connection connection = DriverManager.getConnection(url, user, pass)
        ) {
            System.out.println("Connected to database successfully.");

            // Prepare CallableStatement to call the procedure
            CallableStatement callableStatement = connection.prepareCall(sqlQuery);
            // Set the input parameter: userId=1
            int userIdToSearch = 2;
            callableStatement.setInt(1, userIdToSearch);
            System.out.println("Calling stored procedure 'jdbc.getUserById' with userId=" + userIdToSearch + "...");

            // Execute the procedure
            boolean result = callableStatement.execute();

            if (result) {
                System.out.println("Stored procedure returned a result set. Fetching data...");

                // Retrieve and print the result set
                ResultSet rs = callableStatement.getResultSet();
                boolean dataFound = false;

                while (rs.next()) {
                    dataFound = true;
                    System.out.print("ID: " + rs.getInt("id") + "\t");
                    System.out.print("Name: " + rs.getString("name") + "\t");
                    System.out.println("Email: " + rs.getString("email"));
                }
                rs.close();

            } else {
                System.out.println("Stored procedure did not return a result set.");
                int rowsAffected = callableStatement.getUpdateCount();
                System.out.println("Rows affected: " + rowsAffected);
            }
            callableStatement.close();
            System.out.println("CallableStatement closed successfully.");

        } catch (SQLException e) {
            System.err.println("[ERROR] SQL Exception occurred:");
            e.printStackTrace();
        }
    }
}
