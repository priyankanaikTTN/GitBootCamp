<%--
  Created by IntelliJ IDEA.
  User: priyanka
  Date: 14/4/17
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculate factorial</title>
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

<p>&nbsp;</p>
<table border="1" cellpadding="0"
       cellspacing="0" width="35%" align="center">

    <tr>
        <td width="100%">
            <p align="center"><b>Calculate factorial</b></p>
            <form method="POST" action="factorial.jsp">
                <p align="center"><b>Enter Number:</b>
                    <input type="text" name="num" size="20">
                    <input type="submit" value="Submit" name="B1"></p>
                <p>&nbsp;</p>
            </form>
            <p>&nbsp;</td>
    </tr>
</table>

</body></html>
