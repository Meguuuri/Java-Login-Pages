

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href="style.css">
        <title>Hello!</title>
    </head>
    <body>
        <%@include file="/header.jspf" %>
            
            <form action="index.jsp" method="get" class="starting-page">
                <h1 style="font-size: 200%; font-family: sans-serif; text-align: center;
            ">Character Counter App</h1>
                <h2>ICS2608 Machine Problem 3</h2>
                <h3>Group 5</h3>
                <h4>CALIPES - CORTEZ - DIZON</h4>
                <p><input type="submit" value="Get Started"></p>
            </form>
        <%@include file="/footer.jspf" %>
    </body>
</html>
