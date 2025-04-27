import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFromStudents {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "Prasad@21";

        String deleteQuery = "Delete from students where id = ?;";

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,10);
            int update = preparedStatement.executeUpdate();

            if(update > 0)
            {
                System.out.println("Deleted Successfully !!!");
            }
            else
            {
                System.out.println("Data not deleted");
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }

}
