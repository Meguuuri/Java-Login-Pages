<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
    </head>
    <body>
        <%@ include file="/header.jspf" %>

        <h1>Login Failed</h1>
        <p style="color:red;"><c:out value="${requestScope.errorMessage}"/></p>
        <p><a href="index.jsp">Back to Login</a></p>

        <%@ include file="/footer.jspf" %>
    </body>
</html>
