<%--
  Created by IntelliJ IDEA.
  User: priyanka
  Date: 14/4/17
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.sql.*" %>
<html>
<body>
<div style="float: right; display: block"> <a href="index.jsp"> <button
        style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: block;
    font-size: 16px;">HOME</button></a></div>

<table border="1" cellpadding="0"
       cellspacing="0" width="35%" align="center">

    <tr>
        <td width="100%">
            <p align="center"></p>

            <form action="welcome.jsp">
                <p align="center"><b>

                    Enter User name :</b><input type="text" name="uname" required/></p>

                <p align="center"><b>Enter password:</b> <input type="password" name="pass"required/></p>
                <p align="center"><input type="submit" value="SIGNIN"/></p>
                <p>&nbsp;</p>
            </form>
            <p>&nbsp;</td>
    </tr>
</table>

</body>
</html>
