<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: priyanka
  Date: 14/4/17
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

</body>
<div style="float: right ;display: block"> <a href="signin.jsp"> <button
        style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: block;
    font-size: 16px;">HOME</button></a></div>


<%


    String user = request.getParameter("uname");
    String pwd = request.getParameter("pass");
    String name = request.getParameter("name");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/jsp_bootcamp", "root", "igdefault");

    PreparedStatement ps = con.prepareStatement(
            "insert into user(uname,name,pass) values(?,?,?)");

    ps.setString(1, user);
    ps.setString(2, name);
    ps.setString(3, pwd);


    int i= ps.executeUpdate();
    ps.close();
    if (i > 0) {
        //session.setAttribute("userid", user);
        /*response.sendRedirect("welcome.jsp");*/
        out.println("User successfully registered..... Go to SIGNIN");
        // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        out.println("Cannot register.. Some error.. retry.. go to home page");

    }
%>

</body>
</html>
