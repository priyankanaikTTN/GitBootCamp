import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by priyanka on 27/3/17.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String userName = request.getParameter("uname");
        String userPass = request.getParameter("password");
        ;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Servlet_Bootcamp", "root", "igdefault");

            PreparedStatement ps = con.prepareStatement(
                    "insert into user(username,name,password) values(?,?,?)");

            ps.setString(1, userName);
            ps.setString(2, name);
            ps.setString(3, userPass);


            ps.executeUpdate();
            ps.close();
            request.setAttribute("error","<div " +
                    "style=\" display:block;float : right;margin: 40px 40px; color:coral ; font-size:20px;height:150px;\">" +
                    " SuccessFully  Registered</div>");


        } catch (Exception e2) {
            e2.printStackTrace();
            request.setAttribute("error","<div " +
                    "style=\" display:block;float : right;margin: 40px 40px; color:coral ; font-size:20px;height:150px;\">" +
                    " Unable to Register</div>");

        }


    }


}
