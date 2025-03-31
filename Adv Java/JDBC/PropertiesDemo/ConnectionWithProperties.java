package PropertiesDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionWithProperties {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        String driver = null;
        String url = null;
        String user = null;
        String pass = null;

        while (true){
            FileInputStream fileInputStream = new FileInputStream("D:\\Intel\\JDBC\\JDBC-Connection\\Files\\dbConfig.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            pass = properties.getProperty("password");

            Class.forName(driver);

            try(
                    Connection connection = DriverManager.getConnection(url, user, pass);
                    ResultSet rs = connection.createStatement().executeQuery("Select * from emp_details;");
                ) {
                System.out.println("\nFetching and Displaying Data...");
                while (rs.next()){
                    System.out.print(rs.getInt(1));
                    System.out.print("\t"+rs.getString(2));
                    System.out.print("\t"+rs.getInt(3));
                    System.out.print("\t"+rs.getString(4));
                    System.out.print("\t"+rs.getString(5));
                    System.out.println();
                }
                Thread.sleep(1000);
            } catch (SQLException e) {
                System.err.println("SQL Exception");
            }
        }
    }
}
