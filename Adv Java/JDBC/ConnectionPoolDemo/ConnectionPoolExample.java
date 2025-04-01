/*
package ConnectionPoolDemo;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolExample {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/new_jdbc";
        String User = "root";
        String Password = "Pass@123";

        // ✅ Setting up MySQL DataSource
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(User);
        mysqlDataSource.setPassword(Password);

        // ✅ Configuring HikariCP
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDataSource(mysqlDataSource);
        hikariConfig.setMaximumPoolSize(10);  // ✅ Set max pool size
        hikariConfig.setMinimumIdle(5);       // ✅ Minimum connections to keep open
        hikariConfig.setIdleTimeout(30000);   // ✅ Close idle connections after 30 seconds
        hikariConfig.setMaxLifetime(1800000); // ✅ Max connection lifetime 30 min

        // ✅ Creating Connection Pool
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        System.out.println("Maximum Pool Size: " + hikariDataSource.getMaximumPoolSize());

        // ✅ Using try-with-resources to prevent leaks -> Returns the connection to the pool for reuse
        try (
                Connection con1 = hikariDataSource.getConnection();
                Connection con2 = hikariDataSource.getConnection();
                Connection con3 = hikariDataSource.getConnection();
        ) {
            System.out.println("Connection 1: " + con1);
            System.out.println("Connection 2: " + con2);
            System.out.println("Connection 3: " + con3);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed!", e);
        }

        // ✅ Closing connection pool
        hikariDataSource.close(); // -> 🚫 Closes all connections and shuts down the pool
    }
}
*/
