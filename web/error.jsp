<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Login Error</title>
    </head>
    <body>
        <%@ include file="/header.jspf" %>

        <form action="index.jsp" method="get">
             <h1>Login Failed</h1>
            <p style="color:red; font-weight: bold;"><c:out value="${requestScope.errorMessage}"/></p>
            <p><input type="submit" value="Try Again"></p>
        </form>
        <%@ include file="/footer.jspf" %>
    </body>
</html>
