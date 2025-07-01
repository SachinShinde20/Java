import java.sql.*;
import java.util.Scanner;

public class TransactionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pass = "@Pass123";

        String sql = "Insert into students values(?, ?, ?, ?);";

        try(
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
                Scanner sc = new Scanner(System.in);
        ) {
            connection.setAutoCommit(false);

            int rowsAffected = statement.executeUpdate("delete from students where id = 12");
            System.out.println("Is Transaction Completed: Y/N: ");
            char c = sc.nextLine().charAt(0);
            if(c=='Y'){
                connection.commit();
                System.out.println("Translation Completed");
                System.out.println("Rows Affected: "+rowsAffected);
            }else {
                connection.rollback();
                System.out.println("Translation failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
