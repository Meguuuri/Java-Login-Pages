<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Login</title>
    </head>
    <body>
        <%@ include file="/header.jspf" %>

        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <p>Username: <input type="text" name="username"></p>
            <p>Password: <input type="password" name="password"></p>
            <p><input type="submit" value="Login"></p>
        </form>

        <%@ include file="/footer.jspf" %>
    </body>
</html>
