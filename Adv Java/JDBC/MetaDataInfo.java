import java.sql.*;

public class MetaDataInfo {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/JDBC";
        String User = "root";
        String Password = "Pass@123";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");


            try (
                    // Establish connection
                    Connection con = DriverManager.getConnection(URL, User, Password)
            ) {
                System.out.println("✅ Connection Established: " + con);

                // ─── Database Metadata ───────────────────────────────────────────
                DatabaseMetaData dbMetaData = con.getMetaData();
                System.out.println("\n📌 Database Information:");
                System.out.println("  🔹 Database Name: " + dbMetaData.getDatabaseProductName());
                System.out.println("  🔹 Database Version: " + dbMetaData.getDatabaseProductVersion());
                System.out.println("  🔹 JDBC Driver Name: " + dbMetaData.getDriverName());
                System.out.println("  🔹 JDBC Driver Version: " + dbMetaData.getDriverVersion());
                System.out.println("  🔹 Database URL: " + dbMetaData.getURL());
                System.out.println("  🔹 User: " + dbMetaData.getUserName());

                // Fetching database limits
                System.out.println("\n📌 Database Limits:");
                System.out.println("  🔹 Max Connections: " + dbMetaData.getMaxConnections());
                System.out.println("  🔹 Max Columns in Index: " + dbMetaData.getMaxColumnsInIndex());
                System.out.println("  🔹 Max Column Name Length: " + dbMetaData.getMaxColumnNameLength());
                System.out.println("  🔹 Max Columns in Table: " + dbMetaData.getMaxColumnsInTable());
                System.out.println("  🔹 Max Row Size: " + dbMetaData.getMaxRowSize());

                // ─── Retrieving Table Metadata ──────────────────────────────────
                try (
                        Statement statement = con.createStatement();
                        ResultSet rs = statement.executeQuery("SELECT * FROM employees")
                ) {

                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    int columnCount = rsMetaData.getColumnCount();

                    System.out.println("\n📌 Table Information:");
                    System.out.println("  🔹 Table Name: " + rsMetaData.getTableName(1));
                    System.out.println("  🔹 Number of Columns: " + columnCount);

                    // Loop through each column and fetch metadata
                    System.out.println("\n📌 Column Details:");
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.println("  🔹 Column " + i + ":");
                        System.out.println("     ➤ Name: " + rsMetaData.getColumnName(i));
                        System.out.println("     ➤ Type: " + rsMetaData.getColumnTypeName(i));
                        System.out.println("     ➤ Display Size: " + rsMetaData.getColumnDisplaySize(i));
                        System.out.println("     ➤ Is Nullable: " + (rsMetaData.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
                        System.out.println("     ➤ Is Auto-Increment: " + rsMetaData.isAutoIncrement(i));
                        System.out.println("     ➤ Is Read-Only: " + rsMetaData.isReadOnly(i));
                    }
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
