import java.sql.*;

public class ResultSetEx {
    public static void main(String[] args) {

        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "@Pass123");
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ){
           ResultSet resultSet = statement.executeQuery("Select * from jdbc.students");
           while (resultSet.next()){
               int id = resultSet.getInt(1);
               String name = resultSet.getString(2);
               String email = resultSet.getString(3);
               long mobile = resultSet.getLong(4);

               if(id == 6){
                   resultSet.deleteRow();
                   System.out.println("\tRecord of id 6 is deleted");
                   continue;
               }
               if(name.equals("ama")){
                   resultSet.updateString(2, "amaa");
                   resultSet.updateRow();
                   System.out.println("\tRecord of id 13 is modified (ama to amaa)");
               }
               System.out.print(id+"\t"+name+"\t"+email+"\t"+mobile); // shows old name
               System.out.println();
           }
        } catch (SQLException e) {
            System.err.println("Error while Establishing the Connection");
            throw new RuntimeException(e);
        }
    }
}
