<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
    <title>Genelove: Users List</title>

</head>

<body>
<jsp:include page="header.jsp"/>
<h2>User List</h2>
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
        <th colspan="3">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersList}" var="user">
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
                <c:url var="block" value="/admin/block"/>
                <form:form action="${block}" method="post" modelAttribute="user">
                    <form:input type="hidden" path="id" value="${user.id}"/>
                    <button type="submit">Block/Unblock</button>
                </form:form>
            </td>
            <td>
                <c:url var="promote" value="/admin/promote"/>
                <form:form action="${promote}" method="post" modelAttribute="user">
                    <form:input type="hidden" path="id" value="${user.id}"/>
                    <button type="submit">Promote/Demote</button>
                </form:form>
            </td>
            <td>
                <c:url var="delete" value="/admin/delete"/>
                <form:form action="${delete}" method="post" modelAttribute="user">
                    <form:input type="hidden" path="id" value="${user.id}"/>
                    <button type="submit">Delete</button>
                </form:form>
            </td>
            <%--<td>
                <c:url var="show" value="/admin/user/id/${usersList.id}"/>
                <form action="${show}" method="get">
                    <button type="submit">Show</button>
                </form>
            </td>--%>
        </tr>
    </c:forEach>

    </tbody>

</table>

<br>

<h2>Statistics</h2>
<table border="1">
    <thead>
    <tr>
        <th>Total Users</th>
        <th>Blocked Users</th>
        <th>Administrators</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${allUsersCount}</td>
        <td>-</td>
        <td>-</td>
    </tr>
    </tbody>
</table>

</body>
</html>
