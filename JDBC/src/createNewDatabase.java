import java.sql.*;

public class createNewDatabase {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "Prasad@21";

        String createTable = "create table employee3 (\n" +
                "\tid int PRIMARY KEY auto_increment,\n" +
                "\temp_name varchar(50) not null,\n" +
                "\tage int not null,\n" +
                " emp_designation varchar(30)\n" +
                ");";

        Connection connection = null;
        try
        {

            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(createTable);

            preparedStatement.executeUpdate();

            System.out.println("Table in the database created successfully");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }





    }

}
