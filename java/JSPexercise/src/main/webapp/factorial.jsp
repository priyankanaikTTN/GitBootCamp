<%--
  Created by IntelliJ IDEA.
  User: priyanka
  Date: 14/4/17
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="float: right ;display: block"> <a href="index.jsp"> <button
        style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: block;
    font-size: 16px;">HOME</button></a></div>

<%
    int num=Integer.parseInt(request.getParameter("num"));
%>
<%!
    int factorial(int n)
    {
        if (n == 1) {
            return n;
        }
        else {
            return n * factorial(n - 1);
        }
    }
%>
<%
    out.println("The factorial of  " +num+"  is : " + factorial(num));
%>
</body>
</html>
