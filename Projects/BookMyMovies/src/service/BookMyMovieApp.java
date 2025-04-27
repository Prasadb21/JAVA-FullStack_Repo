package service;

import com.mysql.cj.jdbc.SuspendableXAConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookMyMovieApp {
    public static void main(String[] args) {
        BookMyMovieSystem bookMyMovieSystem = new BookMyMovieSystem();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter city");
        String city = sc.next();
        bookMyMovieSystem.displayTheaters(city);

        System.out.println("Enter Theater ID and Movie Id: ");
        int theaterID = sc.nextInt();
        int movieID = sc.nextInt();

        bookMyMovieSystem.displayShows(movieID , theaterID);

        System.out.println("Enter show ID and Number of seats");
        int showID = sc.nextInt();


        List<String> selectedSeats = Arrays.asList("B3" , "B4");
        bookMyMovieSystem.bookTickets(1,showID,selectedSeats);





    }
}
