import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {

    List<User> users = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h2>Register Users </h2>");
        if(users.isEmpty())
        {
            printWriter.println("<p>No User Registered : </p>");
        }
        else
        {
            printWriter.println("<ul>");
            for(User user:users)
            {
                printWriter.println("<li> " + user.getName() + " - " + user.getEmail()+ "</li>");
            }

            printWriter.println("</ul>");
        }

        printWriter.println("<a href = 'index.html'> Back to registration </a>");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        users.add(new User(name , email));
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h2>Registration Successful </h2>");
        printWriter.println("<p> Name : " + name + "</p>");
        printWriter.println("<p> Email : " + email + "</p>");
        printWriter.println("<a href = 'register'> View All Users :  </a> <br>");
        printWriter.println("<a href = 'index.html'> Back to registration </a>");

    }

}

class User
{
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
