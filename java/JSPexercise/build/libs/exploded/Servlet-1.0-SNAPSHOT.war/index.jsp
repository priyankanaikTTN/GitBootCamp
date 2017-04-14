<%@ page import="static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println" %><%--
  Created by IntelliJ IDEA.
  User: priyanka
  Date: 3/4/17
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head><%
  // This scriptlet declares and initializes "date"
  System.out.println( "Evaluating date now" );
  java.util.Date date = new java.util.Date();
%>
  Hello!  The time is now
  <%
    // This scriptlet generates HTML output
    out.println(String.valueOf( date ));
  %></head>
<body>





<div style="margin: 40px 40px; background-color: wheat; height:500px;">
  <div style=" background-color: bisque;padding:80px 50px; width:50%;height: 25%;
 top: 25%; margin: 0 auto; position: relative"
       align="center">

    <a href="signup.jsp" ><button style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: block;
    font-size: 16px;">SIGNUP</button></a>
    <br>

    <a href="fact.jsp"> <button style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: block;
    font-size: 16px;">FACTORIAL</button></a>
    <br>

    <a href="signin.jsp"> <button style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: block;
    font-size: 16px;">SIGNIN</button></a>

  </div>
</div>
</body>
</html>