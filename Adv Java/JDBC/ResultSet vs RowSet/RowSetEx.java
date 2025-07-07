import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetEx {
    public static void main(String[] args) {

        CachedRowSet cachedRowSet = null;

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "@Pass123");
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM jdbc.students");
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultSet); // fetch data into cachedRowSet
            resultSet.close();
            // Connection and Statement will be closed at the end of this try block
        } catch (SQLException e) {
            System.err.println("Error while Establishing the Connection");
            throw new RuntimeException(e);
        }

        // Now connection is closed, but CachedRowSet still has the data offline:
        try {
            while (cachedRowSet.next()) {
                int id = cachedRowSet.getInt(1);
                String name = cachedRowSet.getString(2);
                String email = cachedRowSet.getString(3);
                long mobile = cachedRowSet.getLong(4);

                System.out.println(id + "\t" + name + "\t" + email + "\t" + mobile);
            }
            System.out.println("\t\tData printed successfully from CachedRowSet even after closing connection!");
        } catch (SQLException e) {
            System.err.println("Error while iterating CachedRowSet");
            throw new RuntimeException(e);
        }
    }
}
