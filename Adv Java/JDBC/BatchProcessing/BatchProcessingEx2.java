package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessingEx2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC";
        String user = "root";
        String password = "Pass@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                    Connection connection = DriverManager.getConnection(url, user, password);
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO xyz VALUES (?, ?, ?)");
                    Scanner sc = new Scanner(System.in);
            ) {
                connection.setAutoCommit(false);

                while (true) {
                    System.out.println("Enter Your ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Your Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter Your Email: ");
                    String email = sc.nextLine();

                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, email);

                    preparedStatement.addBatch();

                    System.out.println("\nDo You Want To Continue? (Y/N)");
                    char choice = sc.next().charAt(0);
                    sc.nextLine();

                    if (choice != 'y' && choice != 'Y') {
                        int[] rowsAffected = preparedStatement.executeBatch();

                        // Commit transaction
                        connection.commit();

                        System.out.println("✅ Batch Execution Completed!");
                        System.out.println("Rows Affected: ");
                        for (int i : rowsAffected) {
                            System.out.println(i);
                        }
                        break;
                    }
                }
            } catch (SQLException e) {
                System.err.println("❌ SQL Error! Rolling Back...");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver Not Found!");
            e.printStackTrace();
        }
    }
}
