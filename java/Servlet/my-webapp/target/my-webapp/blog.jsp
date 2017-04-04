<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Blog</title>
</head>
<body>


<div style="margin: 40px 40px; background-color: wheat; height:500px;">
    <div><a href="login.jsp"> <button style=" float:right;background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;">HOME</button> </a></div>
    <form method="post" action="/my-webapp/blogForm" style="display: block;
            width:50%;
            height: 25%;
            top: 10%;
            margin: 0 auto;
            position: relative">
        <div  style="display: block; border:solid;background-color: salmon;padding: 20px 20px"
              align="center">
            USER_ID
            <input style="display: block" type="text" name="userid" value="<%=request.getAttribute("id")%>" required><br><br>
            BLOG_ID
            <input style="display: block"  type="text" name="blogid" value="<%=request.getAttribute("bid")%>" required><br><br>
            BLOGNAME
            <input style="display: block" type="text" name="blogname" required><br><br>
            BLOG_COMMENT
            <input style="display: block" type="text" name="blogcomment" required><br><br>

            <input style="background-color: cadetblue;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;" type="submit" value="SAVE">
        </div>
    </form>

    <%=(request.getAttribute("error")==null)?"":request.getAttribute("error").toString()%>

</div>

</body>
</html>