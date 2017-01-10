<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Join status</p>
<table>
    <c:forEach var="item" items="${join}">
        <tr>
            <td>${item.id}</td>
            <td>${item.team}</td>
            <td>${item.points}</td>
            <td>${item.owner}</td>
            <td>${item.name}</td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
