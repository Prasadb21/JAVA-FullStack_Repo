package service;

import config.DatabaseConfig;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class BookMyMovieSystem {

    Scanner sc = new Scanner(System.in);

    // display movies

    public void displayMovies()
    {
        try {
            Connection connection = DatabaseConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from movies");
            System.out.println("--------------- Available Movies ---------------");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("movie_id") +
                                   ". " + resultSet.getString("title") + "(" +
                                   resultSet.getString("genere") + ")" );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // show theater in cities

    public void displayTheaters(String city)
    {
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement("Select * from theatre where city = ? ");
            statement.setString(1,city);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Theaters in " + city + ":");

            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("t_id") + ". " + resultSet.getString("name"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // display shows
    public void displayShows(int movie_id , int theaterId)
    {
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement("Select * from shows where movie_id = ? AND t_id = ?; ");
            statement.setInt(1,movie_id);
            statement.setInt(2,theaterId);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("--------------- Available Shows ---------------");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("show_id") + ". " +
                                    resultSet.getString("timing") +
                                    " - Seats Available: " +
                                    resultSet.getInt("available_seat")
                                    );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Book ticket

    public void bookTickets(int userID , int showID , List<String> selectedSeats )
    {
        try {
            Connection connection = DatabaseConfig.getConnection();
            connection.setAutoCommit(false);

            // check if seats are available
            boolean alreadyBookedSeat = false;

            for(String seat:selectedSeats)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from seat where seat_number = ? AND show_id = ?");
                preparedStatement.setString(1,seat);
                preparedStatement.setInt(2,showID);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next() && resultSet.getBoolean("is_booked"))
                {
                    alreadyBookedSeat = true;
                    System.out.println("seat" + seat + " is already booked. Choose another seat !!");
                }
            }

            if(alreadyBookedSeat)
            {
                System.out.println("Booking failed!!!  Some seats from the selected one's are already booked ");
                connection.rollback();
                return;
            }

            for (String seat : selectedSeats)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE seat SET is_booked = TRUE WHERE  seat_number = ? and show_id = ?");
                preparedStatement.setString(1,seat);
                preparedStatement.setInt(2,showID);
                preparedStatement.executeUpdate();

            }

            double setPrice = 200.0;
            double totalPrice = selectedSeats.size() * setPrice;

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bookings (user_id, show_id, seats_booked, total_price) VALUES (?,?,?,?);");
            preparedStatement.setInt(1,userID);
            preparedStatement.setInt(2,showID);
            preparedStatement.setString(3 , String.join("," , selectedSeats));
            preparedStatement.setDouble(4,totalPrice);
            preparedStatement.executeUpdate();
            connection.commit();

            System.out.println("Booking successful!! | Seats : " + selectedSeats + " | Total Price: " + totalPrice);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
