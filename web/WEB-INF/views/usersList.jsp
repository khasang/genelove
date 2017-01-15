<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<table>
    <thead><tr>
        <th>Statitistics</th>
    </tr>
    </thead>
    <tr>
        <td>Total Users</td>
        <td>Blocked Users</td>
        <td>Administrators</td>
    </tr>
    <tr>
        <td>${allUsersCount}</td>
        <td>-</td>
        <td>-</td>
    </tr>
</table>
<table>
    <thead><tr>
        <th>Users List</th>
    </tr>
    </thead>
    <tr>
        <td>ID</td>
        <td>Login</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>E-mail</td>
        <td>Account Status</td>
        <td>Roles</td>
    </tr>
    <c:forEach items="${usersList}" var="usersList">
        <tr>
            <td>${usersList.id}</td>
            <td>${usersList.login}</td>
            <td>${usersList.firstName}</td>
            <td>${usersList.lastName}</td>
            <td>${usersList.email}</td>
            <td>${usersList.accountStatus}</td>
            <td>
            <c:forEach var="role" items="${usersList.roles}">
                ${role.roleName},
            </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</table>
</body>
</html>
