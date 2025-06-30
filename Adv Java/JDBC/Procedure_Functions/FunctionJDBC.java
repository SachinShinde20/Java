package Procedure_Functions;

import java.sql.*;

public class FunctionJDBC {
    public static void main(String[] args) {
        /*
        MySQL function expected in DB:
        ---------------------------------
        DELIMITER $$

        CREATE FUNCTION jdbc.getUserEmail(userId INT) RETURNS VARCHAR(100)
        DETERMINISTIC
        BEGIN
            DECLARE email VARCHAR(100);
            SELECT users.email INTO email FROM users WHERE users.id = userId;
            RETURN email;
        END $$

        DELIMITER ;
         */

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pass = "@Pass123";

        // Correct JDBC call syntax for a function: ? = call functionName(?)
        String sqlQuery = "{ ? = CALL jdbc.getUserEmail(?) }";

        try (
                Connection connection = DriverManager.getConnection(url, user, pass)
        ) {
            System.out.println("Connected to database successfully.");

            // Prepare CallableStatement for function call
            CallableStatement callableStatement = connection.prepareCall(sqlQuery);

            // Register the first parameter as the function return value
            // "{ ? = CALL jdbc.getUserEmail(?) }" ->  return Type of function will be String
            callableStatement.registerOutParameter(1, Types.VARCHAR);

            // Set the second parameter as the input argument: userId
            int userIdToSearch = 2;
            callableStatement.setInt(2, userIdToSearch);

            System.out.println("Calling function 'jdbc.getUserEmail' with userId=" + userIdToSearch + "...");

            // Execute the function call
            callableStatement.execute();

            // Retrieve the return value of the function
            String email = callableStatement.getString(1);

            if (email != null) {
                System.out.println("Function returned email: " + email);
            } else {
                System.out.println("No user found with userId=" + userIdToSearch + ".");
            }

            callableStatement.close();
            System.out.println("CallableStatement closed successfully.");

        } catch (SQLException e) {
            System.err.println("SQL Exception occurred:");
            e.printStackTrace();
        }
    }
}
