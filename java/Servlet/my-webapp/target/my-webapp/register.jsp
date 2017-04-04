<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>
</head>
<body>


<div style="margin: 40px 40px; background-color: wheat; height:500px;">

    <div><a href="Welcome.jsp"> <button style=" float:right;background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;">HOME</button> </a></div>
`
    <form method="post" action="/my-webapp/registerForm" style="
            width:50%;
            height: 25%;
            top: 25%;
            margin: 0 auto;
            position: relative">
    <div  style=" border:solid;background-color: salmon;padding: 20px 20px"
          align="center">
        NAME
        <input style="display: block" type="text" name="name" required ><br><br>
    USERNAME
        <input style="display: block" type="text" name="uname" required><br><br>
    PASSWORD
        <input  style="display:block;" type="password" name="password" required><br><br>

    <input style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;" type="submit" value="REGISTER">
    </div>
</form>
</div>
<%=(request.getAttribute("error")==null)?"":request.getAttribute("error").toString()%>


</body>
</html>