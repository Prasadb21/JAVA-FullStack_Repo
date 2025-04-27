import java.security.spec.ECField;
import java.sql.*;

public class InsertIntoStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "Prasad@21";

        String insertQuery  = "insert into students(name,age,course) values(?,?,?);";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);
            // 3. Create statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // first insert
            preparedStatement.setString(1 , "Yoguuu");
            preparedStatement.setInt(2 , 23);
            preparedStatement.setString(3 , "DSA");

            preparedStatement.executeUpdate();

            // second insert
            preparedStatement.setString(1,"Dhabbu");
            preparedStatement.setInt(2,22);
            preparedStatement.setString(3,"DSA");

            preparedStatement.executeUpdate();

            System.out.println("Data inserted successfully !!!");

        }
        catch (Exception e)

        {
            e.printStackTrace();
        }

    }

}
