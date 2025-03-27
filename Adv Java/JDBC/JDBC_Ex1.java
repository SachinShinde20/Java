import java.sql.*;
import java.text.SimpleDateFormat;

public class JDBC_Ex1 {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306";
        String User = "root";
        String Password = "Pass@123";

        // SQL query to create a table with various data types
        String tableCreation = "CREATE TABLE JDBC.Example_table ("
                + "srNo INT AUTO_INCREMENT PRIMARY KEY, "
                + "id INT, "
                + "name VARCHAR(100), "
                + "age INT, "
                + "salary DECIMAL(10, 2), "
                + "balance DOUBLE, "
                + "created_date DATE, "
                + "mobile_no VARCHAR(15)"
                + ");";

        // Static SQL queries for inserting fixed data into the table
        String insertQuery1 = "INSERT INTO JDBC.Example_table (id, name, age, salary, balance, created_date, mobile_no) VALUES (101, 'Roy', 30, 50000.00, 1000.50, '2025-03-27', '1111111111');";
        String insertQuery2 = "INSERT INTO JDBC.Example_table (id, name, age, salary, balance, created_date, mobile_no) VALUES (102, 'Tonny', 28, 60000.00, 1500.75, '2025-03-27', '2222222222');";
        String insertQuery3 = "INSERT INTO JDBC.Example_table (id, name, age, salary, balance, created_date, mobile_no) VALUES (103, 'John', 35, 75000.00, 2000.25, '2025-03-27', '3333333333');";
        String selectQuery = "Select * from JDBC.example_table;";

        // Dynamic SQL query for inserting data using PreparedStatement
        String dynamicQuery = "INSERT INTO JDBC.Example_table (id, name, age, salary, balance, created_date, mobile_no) VALUES (?,?,?,?,?,?,?);";

        try (
                // Establishing a connection to the database
                Connection connection = DriverManager.getConnection(URL, User, Password);

                // Creating a Statement for executing static queries
                Statement statement = connection.createStatement();

                // Creating a PreparedStatement for executing dynamic queries
                PreparedStatement preparedStatement = connection.prepareStatement(dynamicQuery);
        ) {
            /*
             * ---------------------------------------------------------------------------------
             * SECTION 1: TABLE CREATION
             * ---------------------------------------------------------------------------------
             */
            // Executing the table creation query
            int noOfRecordsAffected = statement.executeUpdate(tableCreation);
            System.out.println("✅ Table Created Successfully...");
            System.out.println("No of Records Affected: " + noOfRecordsAffected);

            /*
             * ---------------------------------------------------------------------------------
             *  SECTION 2: STATIC QUERY EXECUTION (Hardcoded Data)
             * ---------------------------------------------------------------------------------
             */
            // Executing static insert queries
            statement.executeUpdate(insertQuery1);
            statement.executeUpdate(insertQuery2);
            statement.executeUpdate(insertQuery3);
            System.out.println("\n✅ Static Query Executed Successfully...");
            System.out.println("📌 Data has been successfully added using static queries");

            /*
             * ---------------------------------------------------------------------------------
             *  SECTION 3: DYNAMIC QUERY EXECUTION (User-Supplied Values)
             * ---------------------------------------------------------------------------------
             */
            // Setting dynamic values for PreparedStatement
            preparedStatement.setInt(1, 201);
            preparedStatement.setString(2, "Rahul");
            preparedStatement.setInt(3, 21);
            preparedStatement.setDouble(4, 40000.50);
            preparedStatement.setDouble(5, 9990009.99);

            // Converting a string to java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("2025-03-25");  // Parsing the date string
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());  // Converting to java.sql.Date
            preparedStatement.setDate(6, sqlDate);  // Setting the created_date field

            preparedStatement.setString(7, "5555555555");

            // Executing the dynamic insert query
            preparedStatement.executeUpdate();
            System.out.println("\n✅ Dynamic Query Executed Successfully...");
            System.out.println("📌 Data has been successfully added using dynamic queries");

            /*
             * ---------------------------------------------------------------------------------
             *  SECTION 4: Static QUERY EXECUTION (Select)
             * ---------------------------------------------------------------------------------
             */
            System.out.println("\nReading Data...");
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()){
                System.out.print(resultSet.getInt(1));
                System.out.print("\t"+resultSet.getInt(2));
                System.out.print("\t"+resultSet.getString(3));
                System.out.print("\t"+resultSet.getInt(4));
                System.out.print("\t"+resultSet.getDouble(5));
                System.out.print("\t"+resultSet.getDouble(6));
                System.out.print("\t"+resultSet.getDate(7));
                System.out.print("\t"+resultSet.getString(8));
                System.out.println();
            }
            System.out.println("Data Read Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
