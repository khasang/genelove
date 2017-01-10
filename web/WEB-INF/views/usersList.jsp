<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>Login</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>E-mail</td>
        <td>Account Status</td>
        <%--<td>Role ID</td>--%>
    </tr>
    <c:forEach items="${usersList}" var="usersList">
        <tr>
            <td>${usersList.id}</td>
            <td>${usersList.login}</td>
            <td>${usersList.firstName}</td>
            <td>${usersList.lastName}</td>
            <td>${usersList.email}</td>
            <td>${usersList.accountStatus}</td>
            <%--<td>${usersList.role_id}</td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
