import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionEx {
    public static void main(String[] args) {

        // jdbc:<database_type>://<host>:<port>/<database_name>?<parameters>
        String url = "jdbc:mysql://localhost:3306/JDBC";
        String user = "root";
        String pass = "Pass@123";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Explicitly loading the MySQL JDBC Driver (not required for JDBC 4.0+)
            System.out.println("Loading MySQL JDBC Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            System.out.println("Connecting to the database...");
            connection = DriverManager.getConnection(url, user, pass);

            // Create a statement object
            System.out.println("Creating statement...");
            statement = connection.createStatement();

            // Execute query to fetch student records
            System.out.println("Fetching student records...\n");
            resultSet = statement.executeQuery("SELECT * FROM Students");

            // Print header
            System.out.println(" ID\tName\tEmail\tMobile No.");
            System.out.println("------------------------------------------------");

            // Process result set and print data
            while (resultSet.next()) {
                // Fetching data Using ColumnLabel
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int mobileNo = resultSet.getInt("mobileNo");

            /*
                // We can Also fetch data Using the ColumnIndex
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                int mobileNo = resultSet.getInt(4);
            */

                System.out.println(id + "\t" + name + "\t" + email + "\t" + mobileNo);
            }
            System.out.println("\n✅ Operation Completed Successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ SQL Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                System.out.println("🔄 Closing resources...");
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("✅ Resources closed successfully.");
            } catch (SQLException e) {
                System.err.println("⚠️ Warning: Error while closing resources.");
                e.printStackTrace();
            }
        }
    }
}
