import java.sql.*;
import java.util.Stack;
import java.util.stream.StreamSupport;

public class fetchStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "Prasad@21";

        String query = "SELECT * from students;";

        try
        {
            // 1. load karo
//            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Connection bana rahe hai
            Connection connection = DriverManager.getConnection(url , username , password);
            // 3. Create statement
            Statement statement = connection.createStatement();
            // 4. execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // get result
            System.out.println("| ID | Name | Age | Course |");
            System.out.println("-------------------------");
            while (resultSet.next())
            {
                System.out.println("| "  + resultSet.getInt("id") + " | " +
                                    resultSet.getString("name") + " | " +
                                    resultSet.getInt("age")+ " | " +
                                    resultSet.getString("course") + " | ");
            }

        }
        catch
        (Exception e) {
           e.printStackTrace();
        }
    }

}
