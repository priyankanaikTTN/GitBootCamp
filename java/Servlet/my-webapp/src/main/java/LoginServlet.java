import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by priyanka on 2/4/17.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter out = resp.getWriter();

        String userName=req.getParameter("uname");
        String userPass=req.getParameter("password");
        ;


        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Servlet_Bootcamp","root","igdefault");

            PreparedStatement ps=con.prepareStatement(
                    "select id from user where username=? and password=?  ");

            ps.setString(1,userName);

            ps.setString(2,userPass);



            RequestDispatcher rd= req.getRequestDispatcher("blog.jsp");



            ResultSet rs= ps.executeQuery();

            if(rs.next()) {


              ps= con.prepareStatement("select bid from blog order by bid desc limit 1");




                ResultSet rs2= ps.executeQuery();
                int bid = 0;
                while(rs2.next()){
                    bid = rs2.getInt("bid");
                }



                req.setAttribute("id",rs.getInt("id"));


                req.setAttribute("bid",bid+1);

                rd.forward(req,resp);


                ps.close();

            }
            else
            {
                 rd= req.getRequestDispatcher("login.jsp");
                req.setAttribute("error","<div " +
                        "style=\" float : right;margin: 40px 40px; color:coral ; font-size:20px;height:150px;\">" +
                        " Invalid login id or password</div>");
                rd.forward(req,resp);
            }



        }

        catch (Exception e2)
        {
            e2.printStackTrace();
            RequestDispatcher rd= req.getRequestDispatcher("login.jsp");
            req.setAttribute("error","<div " +
                    "style=\" float : right;margin: 40px 40px; color:coral ; font-size:20px;height:150px;\">" +

                    " Unable to login</div>");
            rd.forward(req,resp);
        }

    }
}
