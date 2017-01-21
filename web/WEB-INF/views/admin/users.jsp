<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Genelove: Users List</title>

</head>

<body>

<h2>User List</h2>

<c:url var="newUser" value="/admin/new"/>
<form:form action="${newUser}" method="get">
    <button type="submit">Add User</button>
</form:form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
        <th>Account Status</th>
        <th>Roles</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td><a href="/admin/user/id/${user.id}">${user.login}</a></td>
            <td><a href="/admin/user/id/${user.id}">${user.firstName}</a></td>
            <td><a href="/admin/user/id/${user.id}">${user.lastName}</a></td>
            <td>${user.email}</td>
            <td>${user.accountStatus}</td>
            <td>
                <c:forEach var="role" items="${user.roles}">
                    ${role.roleName},
                </c:forEach>
            </td>
            <td>
                <form:form action="/admin/delete/${user.id}" method="post">
                    <button type="submit">Delete</button>
                </form:form>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

</body>
</html>
