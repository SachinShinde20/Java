import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementEx {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String pass = "@Pass123";

        String sql = "Insert into students values(?, ?, ?, ?);";

        try(
                Connection connection = DriverManager.getConnection(url, user, pass);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            System.out.println("Connection & Prepared statement created successfully...\n");
            preparedStatement.setInt(1, 11);
            preparedStatement.setString(2, "raj");
            preparedStatement.setString(3, "raj@gmail.com");
            preparedStatement.setLong(4, 1122334455L);
            preparedStatement.addBatch();
            System.out.println("Batch 1st added...");

            preparedStatement.setInt(1, 12);
            preparedStatement.setString(2, "sam");
            preparedStatement.setString(3, "sam@gmail.com");
            preparedStatement.setLong(4, 2233445511L);
            preparedStatement.addBatch();
            System.out.println("Batch 2nd added...");

            preparedStatement.setInt(1, 13);
            preparedStatement.setString(2, "ama");
            preparedStatement.setString(3, "ama@gmail.com");
            preparedStatement.setLong(4, 3344551122L);
            preparedStatement.addBatch();
            System.out.println("Batch 3rd added...");

            int[] result = preparedStatement.executeBatch();
            System.out.println("\nBatch executed successfully...");
            for(int i : result){
                System.out.println(i);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
