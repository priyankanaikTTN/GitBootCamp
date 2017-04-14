<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: priyanka
  Date: 14/4/17
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<div style="float: right;display: block"> <a href="index.jsp"> <button
        style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: block;
    font-size: 16px;">LOGOUT</button></a></div>

<%
    String user = request.getParameter("uname");
    String pwd = request.getParameter("pass");

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_bootcamp",
            "root", "igdefault");

    PreparedStatement ps = con.prepareStatement(
            "select * from user where uname=? and pass=?");

    ps.setString(1, user);
    ps.setString(2, pwd);



    ResultSet rs= ps.executeQuery();

      if (rs.next()) {
    //session.setAttribute("userid", user);
        /*response.sendRedirect("welcome.jsp");*/
    out.println("Welcome back "+ user );
    // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
} else {
    out.println("Wrong Password or username.. Some error.. retry.. go to home page");

}
%>

</body>
</html>
