<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
<c:if test="${not empty message}">
    <p><c:out value="${message}"/></p>
</c:if>
</body>
</html>
