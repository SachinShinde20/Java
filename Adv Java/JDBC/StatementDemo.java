import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/JDBC"; // Include the database name in the URL.
        String User = "root";
        String Password = "Pass@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver not found!");
            e.printStackTrace();
            return; // Exit the program if the driver is not found.
        }

        try (
                Connection connection = DriverManager.getConnection(URL, User, Password);
                Statement statement = connection.createStatement()
        ) {
            String query1 = "INSERT INTO xyz VALUES (7, 'Avesh', 'avesh@gmail.com');";
            String query2 = "SELECT * FROM xyz";

            /*
             * executeUpdate() -> Used for INSERT, UPDATE, DELETE, and DDL operations like ALTER, DROP.
             *                          Returns an integer indicating the number of rows affected.
             */
            int noOfRowsAffected = statement.executeUpdate(query1);
            System.out.println("✅ Query 1 Executed Successfully");
            System.out.println("Number of Rows Affected: " + noOfRowsAffected);

            /*
             * executeQuery() -> Used for SELECT operations.
             *                   Returns a ResultSet object containing the retrieved data.
             */
            ResultSet resultSet = statement.executeQuery(query2);
            System.out.println("\n✅ Query 2 Executed Successfully");
            System.out.println("Displaying the Data: ");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));      // Fetching 'id' column
                System.out.print("\t" + resultSet.getString("name"));  // Fetching 'name' column
                System.out.print("\t" + resultSet.getString("email")); // Fetching 'email' column

                // // Alternative way using column indexes instead of column names
                // System.out.print(resultSet.getInt(1));
                // System.out.print("\t" + resultSet.getString(2));
                // System.out.print("\t" + resultSet.getString(3));

                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("❌ SQL Exception occurred!");
            e.printStackTrace();
        }
    }
}
