<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Success</title>
    </head>
    <body>
        <%@ include file="/header.jspf" %>
        
        <h1>Login Successful</h1>
        <form action="CharacterCountingServlet" method="post">
            <p>Enter a string:
                <input type="text" name="inputString" size="50"
                       value="<c:out value='${requestScope.inputString}'/>"></p>
            <p><input type="submit" value="Count"></p>
        </form>

        <%-- Results appear only after CharacterCountingServlet forwards here --%>
        <c:if test="${requestScope.inputString != null}">
            <h2>Results</h2>
            <ul>
                <li>String length: <c:out value="${requestScope.stringLength}"/></li>
                <li>Number of digits: <c:out value="${requestScope.digitCount}"/></li>
                <li>Number of vowels: <c:out value="${requestScope.vowelCount}"/></li>
                <li>Number of consonants: <c:out value="${requestScope.consonantCount}"/></li>
                <li>Number of symbols: <c:out value="${requestScope.symbolCount}"/></li>
            </ul>
        </c:if>

        <%@ include file="/footer.jspf" %>
    </body>
</html>
