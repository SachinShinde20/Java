import java.sql.*;

public class MetaDataEx {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/JDBC";
        String User = "root";
        String Password = "Pass@123";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                    // Establish connection
                    Connection con = DriverManager.getConnection(URL, User, Password);
                    Statement statement = con.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            ) {
                ResultSetMetaData rsMetaData = rs.getMetaData();
                int columnCount = rsMetaData.getColumnCount();

                // Print column headers
                System.out.println("Data:");
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rsMetaData.getColumnName(i) + "\t\t");
                }
                System.out.println();
                System.out.println();

                // Print data rows
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        Object value = rs.getObject(i);
                        System.out.print((value == null ? "NULL" : value) + "\t\t");
                    }
                    System.out.println();
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ SQL Exception!");
            e.printStackTrace();
        }
    }
}