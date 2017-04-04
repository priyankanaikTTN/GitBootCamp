import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
public class BlogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String userid = req.getParameter("userid");
        String blogid = req.getParameter("blogid");
        String blogname = req.getParameter("blogname");
        String blogcomment = req.getParameter("blogcomment");

        RequestDispatcher rd = req.getRequestDispatcher("blog.jsp");

        int i=-1;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Servlet_Bootcamp", "root", "igdefault");

            PreparedStatement ps = con.prepareStatement(
                    "insert into blog(uid,bid,comment,blogname) values(?,?,?,?)");



            ps.setString(1, userid);

            ps.setString(2, blogid);

            ps.setString(3, blogcomment);

            ps.setString(4, blogname);



             i = ps.executeUpdate();

            if(i>=0)
            {
                ps= con.prepareStatement("select bid from blog order by bid desc limit 1");




                ResultSet rs2= ps.executeQuery();
                int bid = 0;
                while(rs2.next()){
                    bid = rs2.getInt("bid");
                }



                req.setAttribute("id",userid);


                req.setAttribute("bid",bid+1);


                req.setAttribute("error","<div " +
                    "style=\" display:block;float : right;margin: 40px 40px; color:coral ; font-size:20px;height:150px;\">" +
                    " SuccessFully Saved your Blog</div>");

                   rd.forward(req,resp);

            }
                    else
            {  req.setAttribute("error","<div " +
                    "style=\" float : right;margin: 40px 40px; color:coral ; font-size:20px;height:150px;\">" +
                    " Could not save your Blog</div>"); }


        } catch (Exception e2) {

            e2.printStackTrace();

            req.setAttribute("error", "<div " +
                    "style=\" float : right;margin: 40px 40px; color:coral ; font-size:20px;height:150px;\">" +
                    " Could not save your blog</div>");
            rd.forward(req, resp);
        }


    }
}
