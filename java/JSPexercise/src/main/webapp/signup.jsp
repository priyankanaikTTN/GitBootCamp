<%--
  Created by IntelliJ IDEA.
  User: priyanka
  Date: 14/4/17
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<html>

<head>

</head>
<body>
<div> <a href="index.jsp"> <button>HOME</button></a></div>

<table border="1" cellpadding="0"
       cellspacing="0" width="35%" align="center">

    <tr>
        <td width="100%">
            <p align="center"></p>

            <form action="registration.jsp">
                <p>&nbsp;</p>
                <p align="center"><b>Enter Name:</b> <input type="text" name="name"required/></p>

                <p align="center"><b>Enter User name :</b><input type="text" name="uname" required/></p>

                <p align="center"><b>Enter password:</b> <input type="password" name="pass"required/></p>
                <p align="center"><input type="submit" value="SIGNIN"/></p>
                <p>&nbsp;</p>
            </form>
            <p>&nbsp;</td>
    </tr>
</table>
</body>
</html>
