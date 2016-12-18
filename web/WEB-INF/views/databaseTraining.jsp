<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Database Training Statuses:</p>
<c:forEach var="list" items="${databaseTraining}">
    <option value ="10"><c:out value="${list}"/></option>
</c:forEach>
</body>
</html>
