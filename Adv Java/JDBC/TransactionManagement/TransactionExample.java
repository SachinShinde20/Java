package TransactionManagement;

import java.sql.*;
import java.util.Scanner;

public class TransactionExample {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "Pass@123";

        String withdrawQuery = "UPDATE account SET balance = balance - ? WHERE accountID = ?";
        String depositQuery = "UPDATE account SET balance = balance + ? WHERE accountID = ?";

        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            // Disable autoCommit to false
            connection.setAutoCommit(false);

            try (
                    PreparedStatement withdrawStatement = connection.prepareStatement(withdrawQuery);
                    PreparedStatement depositStatement = connection.prepareStatement(depositQuery)
            ) {
                System.out.print("Enter Sender Account ID: ");
                String senderID = scanner.nextLine();

                System.out.print("Enter Transfer Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter Receiver Account ID: ");
                String receiverID = scanner.nextLine();

                // ✅ Withdraw from Sender
                withdrawStatement.setDouble(1, amount);
                withdrawStatement.setString(2, senderID);
                int withdrawCount = withdrawStatement.executeUpdate();

                // ✅ Deposit to Receiver
                depositStatement.setDouble(1, amount);
                depositStatement.setString(2, receiverID);
                int depositCount = depositStatement.executeUpdate();

                // ✅ Check if both operations were successful
                if (withdrawCount == 1 && depositCount == 1) {
                    // Save Change to DataBase
                    connection.commit();
                    System.out.println("✅ Transaction Completed Successfully!");
                } else {
                    connection.rollback();
                    System.out.println("❌ Transaction Failed! Rolling Back...");
                }
            } catch (SQLException e) {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("❌ Transaction Rolled Back due to an error!");
                }
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Error!");
            e.printStackTrace();
        } finally {
            try {
                if (scanner != null) scanner.close();
                if (connection != null) {
                    connection.close();
                    System.out.println("🔒 Database Connection Closed.");
                }
            } catch (SQLException e) {
                System.out.println("❌ Error Closing Connection!");
                e.printStackTrace();
            }
        }
    }
}
