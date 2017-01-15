<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genelove: Users List</title>
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
<br>
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
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${usersList}" var="usersList" varStatus="loop">
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
            <td>
                <c:url var="block" value="/admin/block"/>
                <form:form action="${block}" method="post" modelAttribute="user">
                    <form:input type="hidden" path="id" value="${usersList.id}"/>
                    <button type="submit">Block</button>
                </form:form>
            </td>
            <td>
                <c:url var="promote" value="/admin/promote"/>
                <form:form action="${promote}" method="post" modelAttribute="user">
                    <form:input type="hidden" path="id" value="${usersList.id}"/>
                    <button type="submit">Promote</button>
                </form:form>
            </td>
            <td>
                <c:url var="show" value="/admin/user/id/${usersList.id}"/>
                <form action="${show}" method="get">
                    <button type="submit">Show</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
